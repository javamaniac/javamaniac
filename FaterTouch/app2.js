/*
 * TypeError: Cannot read property 'length' of undefined
 * 
 * Veut souvent dire : ne trouve pas le fichier de données
 */
var questions;

       Ext.regModel('Question', {
            fields: ['textQuestion', 'reponses', 'bonneReponse', 'texteExplicatif']    
        });
        
        var store = new Ext.data.Store({
            model: 'Question',
            proxy: {
                type: 'ajax',
                url: 'data.xml',
                reader: {
                    type: 'xml',
                    record: 'question'
                }
            },
            listeners: {
                single: true,
                datachanged: function(){
                    Ext.getBody().unmask();
                    questions = [];
                    
                    store.each(function(rec){
                        //alert("Lecture " + rec.get('textQuestion'));
                        
                        alert("rec.get('reponses')=" + rec.get('reponses'));
                        /*rec.get('reponses').each(function(rec2){
                            alert("rec2 = " + rec2.get('reponse'));
                        };*/
                        
                        questions.push(insertQuestion(
                                                "Question x : " + rec.get('textQuestion'),
                                                [
                                                    "Auprès des personnes handicapées", 
                                                    "Auprès des groupes religieux", 
                                                    "Auprès des immigrants"
                                                ],
                                                rec.get('bonneReponse'),
                                                rec.get('textExplication'),
                                                1
                                            )
                        );
                    });
                    
                    
                    var questionsPanel = new Ext.Panel({
                        fullscreen: true,
                        layout: 'card',
                        items: questions
                    });                 
                    
                    /*var carousel = new Ext.Carousel({
                        items: items,
                        itemId: 'carousel'
                    });*/
                    panel.add(questionsPanel);
                    panel.doLayout();
                }
            }    
        });
        store.read();

var question2;

var overlay;


var popup = new Ext.Panel({
                    floating: true,
                    modal: true,
                    centered: true,
                    width: 200,
                    styleHtmlContent: true,
                    html: '<p>This is a modal, centered and floating panel. hideOnMaskTap is true by default so ' +
                          'we can tap anywhere outside the overlay to hide it.</p>',
                    dockedItems: [{
                        dock: 'top',
                        xtype: 'toolbar',
                        title: 'Overlay Title'
                    }],
                    scroll: 'vertical'
                });

      

function creationBouton(texte, succes, reponse, nextActiveItem)
{
return new Ext.Button({
                        ui  : 'confirm',
                        text: texte,
                        margin: 10,
                        width: "400px",
                        handler: function() {
                                var bravo = (succes) ? 'Bravo, vous avez raison!\n\n' : 
                                    'Ce n\'est pas tout à fait ça.';

                                var msg = new Ext.MessageBox({
                                    html : 'text',
                                    width: '500px'
                                });
                                msg.alert('Réponse', "<p style=\"margin: 10px; font-size: 1.2em; font-weight: bold;\">" + bravo + "</p>" + reponse, function() {
                                    rootPanel.setActiveItem(nextActiveItem, 'cube');
                                });
                        }
                    });
}

function creationBoutons(arrayReponses, bonneReponse, texteExplication, nextActiveItem)
{
    var boutons = new Array();
    
    Ext.each(arrayReponses, function(reponse, index) 
    {
        boutons.push(creationBouton(reponse, true, texteExplication, nextActiveItem));
    });
    return boutons;
}

function insertQuestion(question, arrayReponses, bonneReponse, texteExplication, nextActiveItem)
{
    return new Ext.Panel({
        floating: true,
        centered: true,
        modal: true,
        /*width: '400px',*/
        
        layout: Ext.is.Phone ? 'fit' : {
                type: 'vbox',
                align: 'center',
                pack: 'center'
                },
        
        dockedItems: [{
            dock: 'top',
            xtype: 'toolbar',
            title: question
            }],
            
    	items: creationBoutons(arrayReponses, bonneReponse, texteExplication, nextActiveItem)
            
    });
}

var rootPanel;



new Ext.Application({
    name: "NestedListDemo",

    launch: function() {
	

           

var qquestions = [

//var question1 = 
insertQuestion(
        "Question 1 : Dans quel domaine se font le plus d’accommodements raisonnables au Québec ?",
        [
            "Auprès des personnes handicapées", 
            "Auprès des groupes religieux", 
            "Auprès des immigrants"
        ],
        1,
        "Les chiffres démontrent qu’au Québec, la majorité de la population considèrent qu’ils appartiennent à la religion catholique. Le catholicisme demeure un vecteur identitaire pour la plupart des Québécois. ",
        1
    ),
    
//var question2 = 
insertQuestion(
        "Question 2 : Selon les derniers chiffres de Statistique Canada, combien de Québécois s’identifient à la religion catholique ?",
        ["498 788", "3 285 217", "5 939 720"],
        1,
        "Les chiffres démontrent qu’au Québec, la majorité de la population considèrent qu’ils appartiennent à la religion catholique. Le catholicisme demeure un vecteur identitaire pour la plupart des Québécois.<br>Les recherches récentes de Reginald Bibby (2011) l’amènent à conclure que la thèse de la sécularisation qui prétend que les êtres humains sont de moins en moins croyants et la thèse de la revitalisation qui observe une résurgence du phénomène religieux dans les sociétés modernes se font peu à peu remplacer  par la thèse de la polarisation. Bibby observe effectivement qu’un écart est de plus en plus grand entre croyants et athées, entre affiliation et non-affiliation à une religion et entre l’assistance hebdomadaire et la non-assistance au culte. Les individus sont de plus en plus croyants ou de plus en plus incroyants.",
        2
    ),    
    
//var question3 = 
insertQuestion(
        "Question 3 : Quel profil de personne retrouve-t-on principalement dans les organisations dites «sectes»?",
        [
            "Des gens vulnérables psychologiquement en recherche de réponses rapides", 
            "Des personnes issues d’un milieu peu éduqué, démunies et naïves", 
            "Des individus d’horizons divers représentant exactement la composition actuelle de la société qui sont en quête spirituelle"
        ],
        1,
        "Les recherches ont démontré qu’il n’existe pas de profil d’individus décidant d’adhérer à une organisation sectaire pas plus qu’il existe un profil d’individus qui se convertit à une religion traditionnelle autre que celle de ses parents ou qui se dit athée. <br>Une secte se définit comme un groupe religieux ou idéologique créé en rupture contestataire envers une religion traditionnelle et/ou les valeurs des sociétés modernes. Un groupe devient sectaire en ce sens qu’il peut déraper vers une dangerosité, surtout si ses frontières avec la société sont durcies. La secte se situe cependant sur l’échelle des croyances extrêmes.n",
        3
    ),    

//var question4 = 
insertQuestion(
        "Question 4 : Les hommes peuvent-ils être victimes de la polygamie?",
        ["Oui", "Non"],
        1,
        "Les recherches ont démontré qu’il n’existe pas de profil d’individus décidant d’adhérer à une organisation sectaire pas plus qu’il existe un profil d’individus qui se convertit à une religion traditionnelle autre que celle de ses parents ou qui se dit athée. <br>Une secte se définit comme un groupe religieux ou idéologique créé en rupture contestataire envers une religion traditionnelle et/ou les valeurs des sociétés modernes. Un groupe devient sectaire en ce sens qu’il peut déraper vers une dangerosité, surtout si ses frontières avec la société sont durcies. La secte se situe cependant sur l’échelle des croyances extrêmes.n",
        4
    ), 
//var question5 = 
insertQuestion(
        "Question 5 : En France, qui se pose comme un modèle de laïcité, est-ce que l’état est complètement séparé de l’Église?",
        ["Oui", "Non"],
        1,
        "Les recherches ont démontré qu’il n’existe pas de profil d’individus décidant d’adhérer à une organisation sectaire pas plus qu’il existe un profil d’individus qui se convertit à une religion traditionnelle autre que celle de ses parents ou qui se dit athée. <br>Une secte se définit comme un groupe religieux ou idéologique créé en rupture contestataire envers une religion traditionnelle et/ou les valeurs des sociétés modernes. Un groupe devient sectaire en ce sens qu’il peut déraper vers une dangerosité, surtout si ses frontières avec la société sont durcies. La secte se situe cependant sur l’échelle des croyances extrêmes.n",
        5
    )//; 
]    

var resultat = new Ext.Panel({
    floating: true,
    centered: true,
    modal: true,
    width: '400px',
    
    dockedItems: [{
        dock: 'top',
        xtype: 'toolbar',
        title: 'Résultat'
    }
    ],
	items: [
	
        { html: "<h1>100 %</h1>recommencer." }
            ]
});

function listQuestions()
{
    return questions;
}


rootPanel = new Ext.Panel({
    fullscreen: true,
    layout: 'card',
    items: questions //listQuestions()
});

            /*
            Ext.regModel('modelReponses', {
                fields: ['reponse']
            });
            
            var store = new Ext.data.JsonStore({
                model  : 'modelReponses',
                //sorters: 'reponse',
            
                //getGroupString : function(record) {
                //    return record.get('lastName')[0];
                //},
            
                data: [
                    {reponse: 'vrai'},
                    {reponse: 'faux'}
                ]
            });
            
            var list = new Ext.List({
                fullscreen: true,
                
                itemTpl : '{reponse}',
                //grouped : true,
                //indexBar: true,
                
                store: store
            });
            list.show();
            */
               

	    
/*
        Ext.getBody().mask('Chargement...', 'x-mask-loading', false);
        var panel = new Ext.Panel({
            fullscreen: true,
            layout: 'fit',
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    text: 'First card',
                    handler: function(){
                        var carousel = panel.getComponent('carousel'); 
                        carousel.setActiveItem(0, 'fade');
                    }
                },{
                    text: 'Last Card',
                    handler: function(){
                        var carousel = panel.getComponent('carousel');
                        carousel.setActiveItem(carousel.items.getCount() - 1, 'fade');
                    }
                }]
            }]
        });
        
        Ext.regModel('Card', {
            fields: ['texte', 'cls']    
        });
        
        var store = new Ext.data.Store({
            model: 'Card',
            proxy: {
                type: 'ajax',
                url: 'data.xml',
                reader: {
                    type: 'xml',
                    record: 'card'
                }
            },
            listeners: {
                single: true,
                datachanged: function(){
                    Ext.getBody().unmask();
                    var items = [];
                    
                    store.each(function(rec){
                        items.push({
                            html: rec.get('texte'),
                            cls: 'card ' + rec.get('cls')
                        });
                    });
                    
                    var carousel = new Ext.Carousel({
                        items: items,
                        itemId: 'carousel',
                        //draggable: false,
                        scroll: false
                    });
                    carousel.setDraggable(false);
                    panel.add(carousel);
                    panel.doLayout();
                }
            }    
        });
        store.read();
    	    */
	    
	
    }
});
