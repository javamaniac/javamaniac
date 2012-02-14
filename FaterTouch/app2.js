/*
 * TypeError: Cannot read property 'length' of undefined
 *
 * Veut souvent dire : ne trouve pas le fichier de données
 */


// --- application

new Ext.Application(
{
	name : "FaterTouch",
	
    icon: '/sencha-touch-1.1.1/exemples/kiva/resources/images/kiva.png',
    glossOnIcon: false,
    tabletStartupScreen: '/sencha-touch-1.1.1/exemples/kiva/resources/images/tablet_startup.png',

	launch : function()
	{
		FaterTouch.rootPanel = new Ext.Panel(
		{
			html : '',
			fullscreen : true,
			layout : 'card', // comme un carrousel, mais manuel
			items : FaterTouch.questions
		});

	}
});


FaterTouch.questions = [];
FaterTouch.resultatFinal = 0;
FaterTouch.nombreDeQuestion = 5;
FaterTouch.TITRE;






// ----------------------------------
// --- chargement du modèle : questions

Ext.regModel('Titre',
{
	fields : ['titre'],
	proxy :
	{
		type : 'ajax',
		url : 'data/data.xml',
		reader :
		{
			type : 'xml',
			record : 'questions'
		}
	}
});
FaterTouch.storeTitre = new Ext.data.Store(
{
	model : 'Titre',
	autoLoad : true
});
FaterTouch.storeTitre.load(
{
	callback : function()
	{
		//console.debug('FaterTouch.storeTitre.load');
		FaterTouch.TITRE = FaterTouch.storeTitre.first().get('titre');
		//FaterTouch.resultatPanel.getDockedComponent('toolbar').setTitle('www');//FaterTouch.TITRE
		resultatPanelToolbar.setTitle(FaterTouch.TITRE);
	}
});


Ext.regModel('Question',
{
	fields : ['textQuestion', 'bonneReponse', 'texteExplicatif'],
	hasMany :
	{
		model : 'Reponse',
		name : 'reponses'
	},
	proxy :
	{
		type : 'ajax',
		url : 'data/data.xml',
		reader :
		{
			type : 'xml',
			record : 'question'
		}
	}
});

Ext.regModel('Reponse',
{
	fields : ['reponse'],
	proxy :
	{
		type : 'ajax',
		url : 'data/data.xml',
		reader :
		{
			type : 'xml',
			record : 'reponse'
		}
	}
});

FaterTouch.store = new Ext.data.Store(
{
	model : 'Question',
	autoLoad : true
});

FaterTouch.store.load(
{
	callback : function()
	{

		var itemCpt = 0;

		FaterTouch.store.each(function(question)
		{
			//console.log("log Question : " + question.get('textQuestion') + ":");

			var choixReponses = [];
			question.reponses().each(function(reponse)
			{
				//console.log("	Reponses : " + reponse.raw.textContent);
				choixReponses.push(reponse.raw.textContent);
			});
			
			FaterTouch.questions.push(insertQuestion("<div class='titreNumQuestion'>Question " + (itemCpt + 1) + "</div>" + question.get('textQuestion'), choixReponses, question.get('bonneReponse'), question.get('texteExplicatif'), ++itemCpt));

		});
		
		//console.info('itemCpt:' + itemCpt);
		//FaterTouch.nombreDeQuestion = itemCpt;
		
		FaterTouch.questions.push([FaterTouch.resultatPanel]);
	}
});


var resultatPanelToolbar = new Ext.Toolbar({
			dock : 'top',
			xtype : 'toolbar',
			title : FaterTouch.TITRE
});

FaterTouch.resultatPanel = new Ext.Panel(
	{
		//floating : true,
		centered : true,
		scroll: 'vertical',
		//modal : true,
		//width: '400px',

		layout : Ext.is.Phone ? 'fit' :
		{
			type : 'vbox',
			align : 'center',
			pack : 'center'
		},

		dockedItems : [
			resultatPanelToolbar,
		{
			html : '' // initialisé plustard
		},
		{
			//dock : 'bottom',
			xtype : 'button',
			text : 'Recommencer le questionnaire',
			style: 'margin-top: 10px;',
			//width: '100px',
			handler: function(e){
				//sheet.hide();
				//FaterTouch.rootPanel.setActiveItem(nextActiveItem, 'cube');
				window.location.reload();
			}
		}		
		]//,

		//items : items
		//html: '' // initialisé plustard

	});



// ----------------------------------

function insertQuestion(question, arrayReponses, bonneReponse, texteExplication, nextActiveItem)
{

	//var titreQuestion =
	//var items = [creationBouton("texte", "1", null,
	// 1)].concat(creationBoutons(arrayReponses, bonneReponse, texteExplication,
	// nextActiveItem));
	var items = [new Ext.Panel(
	{
		id : 'question',
		cls: 'blocInfo',
		html : '<div class="question">' + question + '</div>'

	})].concat(creationBoutons(arrayReponses, bonneReponse, texteExplication, nextActiveItem));

	return new Ext.Panel(
	{
		//floating : true,
		centered : true,
		//modal : true,
		//width: '400px',

		layout : Ext.is.Phone ? 'fit' :
		{
			type : 'vbox',
			align : 'center',
			pack : 'center'
		},

		dockedItems : [
		{
			dock : 'top',
			xtype : 'toolbar',
			title : FaterTouch.TITRE
		}],

		items : items

	});
}

function creationBoutons(arrayReponses, bonneReponse, texteExplication, nextActiveItem)
{
	var boutons = new Array();

	var noReponse = 1;
	Ext.each(arrayReponses, function(reponse, index)
	{
		var estBonneReponse = (noReponse == bonneReponse) ? true : false;

		boutons.push(creationBouton(reponse, estBonneReponse, texteExplication, nextActiveItem));
		noReponse++;
	});
	return boutons;
}

function creationBouton(texte, estBonneReponse, texteExplication, nextActiveItem)
{

	/*
	 var datePicker = new Ext.DatePicker({
	 useTitles: true,
	 value: {
	 day: 23,
	 month: 2,
	 year: 1984
	 }
	 });*/

	var reponse = "<div class='bravoErreur'>" + ((estBonneReponse) ? 'Bonne réponse!' : 'Mauvaise réponse!') + "</div>" + texteExplication;
	var texteBouton = (nextActiveItem >= FaterTouch.nombreDeQuestion) ? 'Voir vos résultats ⇨' : 'Question suivante ⇨';
	//console.info('nextActiveItem:' + nextActiveItem);
	//console.info('FaterTouch.nombreDeQuestion:' + FaterTouch.nombreDeQuestion);

	// volet de la bonne réponse
	var sheet = new Ext.Sheet(
	{
		modal : true,
		centered : false,

		//hideOnMaskTap : true,

		layout : 'fit',
		enter : 'right',
		exit : 'right',

		// we always want the sheet to be 400px wide and to be as tall as the device
		// allows
		width : 500,
		//height : 200,
		stretchX : true,
		stretchY : true,

		layout :
		{
			type : 'hbox',
			align : 'stretch'
		},

		dockedItems : [
{
			dock : 'top',
			xtype : 'toolbar',
			cls: 'toolbarReponse',			
			title : 'Réponse'
	},
		/*{
			xtype : 'toolbar',
			dock : 'top',
			items : [
			{
				text : 'Réponse'
			}]
		},*/

		{
			//fullscreen: true,
			scroll: 'vertical',
			html : reponse,
			/*layout :
			{
				type : 'hbox',
				align : 'stretch'
			},*/
			//stretchY : true,
			cls: 'texteExplication'
		},

		/*{
		 //dock : 'top',
		 xtype: 'panel',
		 centered: true,
		 html: 'contenu'
		 },*/
		/*{
		 dock:
		 html : 'Docked to the bottom'
		 },*/
		{
			dock : 'bottom',
			xtype : 'toolbar',
			cls: 'toolbarReponse',
			items: [
				{
					xtype : 'button',
					text : texteBouton,
					//style: 'margin-top: 10px;',
					cls: 'boutonQuestionSuivante',
					centered : true,
					//width: '100px',
					handler: function(e){
						sheet.hide();
						FaterTouch.rootPanel.setActiveItem(nextActiveItem, 'flip'); //cube, slide 
					}
					
				}
			]
		}]
	});




	// Boutons des réponses
	return new Ext.Button(
	{
		ui : 'confirm', //confirm
		text : texte,
		margin : 10,
		//minWidth : "400px",
		style : "min-width: 400px;",
		handler : function()
		{

			//datePicker.show();
			if (estBonneReponse) {
				FaterTouch.resultatFinal++;
				//console.log("Bonne réponse : " + FaterTouch.resultatFinal);
			}
			/*
			else
			{
				console.log("Mauvaise réponse : " + FaterTouch.resultatFinal);
			}*/

			var xBonneReponse = (FaterTouch.resultatFinal > 1) ? " bonnes réponses" : " bonne réponse";
			var resultatIntroduction = (FaterTouch.resultatFinal < 4) ? "Besoin d’augmenter votre score?" : "Vous avez une bonne connaissance du religieux contemporain. Vous seriez intéressés à approfondir certaines de ces questions?";
			var texteFinal = '' +
				'<div>' +
				'	<div>&nbsp;</div>' +
				'	<div class="blocInfo blocResultat">' +
				'		<div>' +
				'			<img src="images/etoile.jpg" style="' + ((FaterTouch.resultatFinal>0) ? '' : 'opacity: 0.3;') + '"/>' +
				'			<img src="images/etoile.jpg" style="' + ((FaterTouch.resultatFinal>1) ? '' : 'opacity: 0.3;') + '"/>' +
				'			<img src="images/etoile.jpg" style="' + ((FaterTouch.resultatFinal>2) ? '' : 'opacity: 0.3;') + '"/>' +
				'			<img src="images/etoile.jpg" style="' + ((FaterTouch.resultatFinal>3) ? '' : 'opacity: 0.3;') + '"/>' +
				'			<img src="images/etoile.jpg" style="' + ((FaterTouch.resultatFinal>4) ? '' : 'opacity: 0.3;') + '"/>' +
				'		</div>' +
				'		<div>Vous avez obtenu<br/>' + FaterTouch.resultatFinal + xBonneReponse + ' sur 5.</div>' +
				'		<div class="texteResultat" style="font-size: 0.8em; margin:auto;font-weight: normal;margin-top: 20px;text-align: left;">' +
				'			<div>' + resultatIntroduction + '</div>' + 
				'			<div>Une formation en étude du religieux contemporain vous exposerait aux thématiques abordées par ce questionnaire. Voici quelques titres de cours donnés à la Faculté&nbsp;:</div>' +
				'			<div><ul>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/shr332">Contacts entre cultures et religions</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/erc712">Éthiques religieuses et débats sociaux</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/thl760">Les nouveaux mouvements religieux</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/erc300">Femmes, religions et spiritualités</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/erc301">Faits religieux et médias</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/erc302">Égalité femme/homme, laïcité et religions</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/thp704">Santé, souffrance et soins spirituels</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/erc304">Sexualité, amour et spiritualités</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/shr886">La formation des identités religieuses</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/shr114">Phénoménologie de la religion au Québec</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/shr895">Le religieux contemporain au Canada</a></li>' +
				'				<li><a target="_blank" href="http://www.usherbrooke.ca/fiches-cours/shr896">Religion, politique et identité</a></li>' +
				'			</ul></div>' +
				'			<div>Sans oublier <a target="_blank" href="http://www.USherbrooke.ca/fater/ecole-ete">l’École d’été</a> sur les religions en modernité avancée qui se donne au Campus de Longueuil.</div>' + 
				'		</div>' +
				'	</div>' +
				'</div>';
			
			// TODO à ne faire qu'après la dernière question
			FaterTouch.resultatPanel.update(
			{
				html : texteFinal 
				//'<div>&nbsp;</div><div class="blocInfo blocResultat">Vous avez obtenu<br/>' + FaterTouch.resultatFinal + xBonneReponse + ' sur 5. </div><div class="texte" style="font-size:1.0em; width:75%; margin:auto;">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.<br/>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).<br/>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</div>' //<span class="FaterTouch.resultatFinal">' + (FaterTouch.resultatFinal * 100 / FaterTouch.nombreDeQuestion) + ' %</span></div>'
			});		

				
				
				//'<div class="blocInfo blocResultat">Votre résultat : <span class="FaterTouch.resultatFinal">' + (FaterTouch.resultatFinal * 100 / FaterTouch.nombreDeQuestion) + ' %</span></div>');
			
			sheet.show();

			//var bravo = (succes) ? 'Bravo, vous avez raison!\n\n' : 'Ce n\'est pas tout à fait ça.';

			/*
			 var msg = new Ext.MessageBox(
			 {
			 html : 'text',
			 width : '500px'
			 });
			 msg.alert('Réponse', "<p style=\"margin: 10px; font-size: 1.2em; font-weight:
			 bold;\">" + bravo + "</p>" + reponse, function()
			 {
			 FaterTouch.rootPanel.setActiveItem(nextActiveItem, 'cube');
			 });
			 */
		}
	});
}

// -----------------------------

// ----------------------------------
