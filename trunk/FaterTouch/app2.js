/*
 * TypeError: Cannot read property 'length' of undefined
 *
 * Veut souvent dire : ne trouve pas le fichier de données
 */

var questions = [];
var question2;
var overlay;
var rootPanel;
var resultatFinal = 0;

var resultat = new Ext.Panel(
{
	floating : true,
	centered : true,
	modal : true,
	width : '400px',

	dockedItems : [
	{
		dock : 'top',
		xtype : 'toolbar',
		title : 'Résultat'
	}],
	items : [
	{
		html : "<h1>100 %</h1>recommencer."
	}]
});

// ----------------------------------
// --- chargement du modèle : questions

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
		url : 'data.xml',
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
		url : 'data.xml',
		reader :
		{
			type : 'xml',
			record : 'reponse'
		}
	}
});

var store = new Ext.data.Store(
{
	model : 'Question',
	autoLoad : true
});

store.load(
{
	callback : function()
	{

		var itemCpt = 0;

		store.each(function(question)
		{
			console.log("log Question : " + question.get('textQuestion') + ":");

			var choixReponses = [];
			question.reponses().each(function(reponse)
			{
				console.log("	Reponses : " + reponse.raw.textContent);
				choixReponses.push(reponse.raw.textContent);
			});
			
			questions.push(insertQuestion("<div class='titreNumQuestion'>Question " + (itemCpt + 1) + "</div>" + question.get('textQuestion'), choixReponses, question.get('bonneReponse'), question.get('texteExplicatif'), ++itemCpt));

		});
	}
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
			title : 'Questionnaire Fater'
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

	var reponse = "<div class='bravoErreur'>" + ((estBonneReponse) ? 'Bravo, vous avez raison!' : 'Ce n\'est pas tout à fait ça.') + "</div>" + texteExplication;


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
		width : 400,
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
			//dock : 'bottom',
			xtype : 'button',
			text : 'Question suivante',
			style: 'margin-top: 10px;',
			//width: '100px',
			handler: function(e){
				sheet.hide();
				rootPanel.setActiveItem(nextActiveItem, 'cube');
			}
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
				resultatFinal++;
			}
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
			 rootPanel.setActiveItem(nextActiveItem, 'cube');
			 });
			 */
		}
	});
}

// -----------------------------

// ----------------------------------
// --- application

new Ext.Application(
{
	name : "FaterTouch",

	launch : function()
	{
		rootPanel = new Ext.Panel(
		{
			html : 'fond',
			fullscreen : true,
			layout : 'card', // comme un carrousel, mais manuel
			items : questions
		});

	}
});
