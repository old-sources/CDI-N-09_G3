function member(arg)
{
    var options = arg||{};
    this.id = options.id;
    this.firstName = options.firstName;
    this.lastName = options.lastName;
    this.mail = options.mail;
    this.phoneNumber = options.phoneNumber;
    this.year = options.year;
    this.yearName = options.yearName;
    this.skills = options.skills;//on peut faire un get ajax pour recup les compétences
    this.status = options.status;
    this.statusName = options.statusName;
}


/********************************	GESTION project	***************************************/
var myProject = {
	val : new project(),
	init : function(){
		//ajax get val projet
		this.displayProject();
	},
	alocateMember : function(){
		/*$.ajax({
            type: "GET",
            url: "project/"+id+"/member",
            dataType: "JSON",
            success: function(json)
            {
                for(var i in json)
                {
                	this.val.member.push(new member(json[i]));
                }
            }
            error: function(){
                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
            }   
        });*/
		this.val.members = [
				//on peut avoir que l'id du participant puis refaire une requete ajax pour get tous les attributs du participant
				new member({id:1,firstName:'gérard',lastName:'bouchard',statusName:'Chef de projet'}),
				new member({id:2,firstName:'michel',lastName:'bouchard1',statusName:'Participant'}),
				new member({id:4,firstName:'romain',lastName:'petiot',statusName:'Candidature en cours'}),
				new member({id:3,firstName:'jean-luc',lastName:'bouchard2',statusName:'Invitation en cours'})];
	},
	displayProject : function(){
		$("#ProjectName").text(this.val.name);
		$("#projectDescription").html(this.val.description);
		$("#wikiManager").html(this.val.wikiManager);
		$("#wikiMember").html(this.val.wikiMember);
		$("#projectStatus").val(this.val.status);
		$("#projectProgress").val(this.val.progress);
		$('#projectProgressText').text(this.val.progress+' %');
		tinymce.init({
		    selector: "div.editable",
		    inline: true,
		    plugins: [
		        "advlist autolink lists link charmap preview anchor",
		        "searchreplace visualblocks fullscreen",
		        "table contextmenu paste"
		    ],
		    toolbar: "insertfile undo redo | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist | link"
		});
		tinymce.init({
		    selector: "h2.editable",
		    inline: true,
		    toolbar: "undo redo",
		    menubar: false
		});
	}
}
