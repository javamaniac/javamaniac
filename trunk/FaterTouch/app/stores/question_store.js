NestedListDemo.music_store = new Ext.data.TreeStore({
    model: 'ListItem',
    proxy: {
        type: 'ajax',
        url: 'data/questions.json',
        reader: {
            type: 'tree',
            root: 'items'
        }
    },
        launch: function() {
	    console.log("NestedListDemo.music_store");
    }
});
