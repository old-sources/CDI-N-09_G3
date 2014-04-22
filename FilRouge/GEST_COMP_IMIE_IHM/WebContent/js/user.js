var nodeSelect = null;//utiliser pour proposer une compétence

//fonction recursive pour recup les nouvelles notes
function getNote(id,nodeSkill)
{
    var text = 0;
    if(!nodeSkill)
    {
        for(var i in thisUser.skills)
        {
            if(text == 0)
            {
                text = getNote(id, thisUser.skills[i]);
            }
        }
    }
    else
    {
        if(nodeSkill.id == id)
        {
            text = nodeSkill.note;
            return text;
        }
        else if(text == 0)
        {
            for(var i in nodeSkill.children)
            {
                if(text == 0)
                {
                    text = getNote(id, nodeSkill.children[i]);
                }
                else
                {
                    return text;
                }
            }
        }
    }
    return text;
}

function displaySkillRecur(nodeSkill)
{
    var retour = '';
    if(nodeSkill.note > 0)
    {
        if(nodeSkill.name)
        {
            retour += '<li>'+nodeSkill.name;
        }
        else
        {
            retour += '<li>'+nodeSkill.label;
        }
    }
    for(var i=0;i<nodeSkill.note;i++)
    {
        retour += '<img src="img/star.png" class="star">';
    }
    if(nodeSkill.children)
    {
        retour += '<ul>';
        for(var i in nodeSkill.children)
        {
            retour += displaySkillRecur(nodeSkill.children[i]);
        }
        retour += '</ul>';    
    }
    retour += '</li>';
    return retour;
}

var thisUser = {
    val : '',
    skills :'',
    init : function(){
        $.ajax({
            type: "GET",
            url: "user/"+idUser,
            dataType: "JSON",
            success: function(json)
            {
                thisUser.val = new user(json);  
                thisUser.skills = [
                               {
                                   label: 'Chatons ', id:1, note:4, 
                                   children: [
                                       { label: 'Qui dorment', id:2, note:2 }, 
                                       { label: 'Qui font des bétisent', id:3, note:4,
                                           children: [
                                               { label: 'Grimpent aux rideaux', id:4, note:0 }, 
                                               { label: 'Qui font caca dans le lit', id:5, note:4  }]  
                                       }]
                               }, 
                               { 
                                   label: 'Chien', id:6, note:4, 
                                   children: [
                                       { label: 'de chasse', id:7, note:5  } ,
                                       { label: 'de promenade', id:8, note:5  } 
                                   ] 
                               }
                           ];
                thisUser.displayUser();
                thisUser.displaySkill();
            },
            error: function(){
                noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
            }   
        });
        //this.val = new user({firstName:'Bouchard',lastName:'Gérard',mail:'gerard@bouchard.com',year:1, yearName:'CDI 09 ',availability : 1, availabilityName : 'Disponible'});
        /*$.ajax({
                type: "GET",
                url: "user/"+id+"/skill,
                dataType: "JSON",
                async : false,
                data: 'idUser='+thisUser.id,
                success: function(json)
                {
                    // affectation thisUser.skills = json
                }
                error: function(){
                    noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
                }   
            });*/
        /*this.skills = [
                {
                    label: 'Chatons ', id:1, note:4, 
                    children: [
                        { label: 'Qui dorment', id:2, note:2 }, 
                        { label: 'Qui font des bétisent', id:3, note:4,
                            children: [
                                { label: 'Grimpent aux rideaux', id:4, note:0 }, 
                                { label: 'Qui font caca dans le lit', id:5, note:4  }]  
                        }]
                }, 
                { 
                    label: 'Chien', id:6, note:4, 
                    children: [
                        { label: 'de chasse', id:7, note:5  } ,
                        { label: 'de promenade', id:8, note:5  } 
                    ] 
                }
            ];
            this.displayUser();
            this.displaySkill();*/
    },
    displayUser : function() {
            $("#userFirstName").text(thisUser.val.firstName);
            $("#userLastName").text(thisUser.val.lastName);
            $("#userMail").text(thisUser.val.mail);
            $("#userYearName").text(thisUser.val.yearName);
            $("#userAvailability").text(thisUser.val.availabilityName);
        },
    displaySkill : function(){
        var txt = '';
        for(i in thisUser.skills)
        {
            txt += displaySkillRecur(thisUser.skills[i]);
        }
        $("#DisplayUserSkill").html(txt);
    },
    displayFormUpdate : function(){
        $.ajax({
            type: "GET",
            url: "userFormUpdate.php",
            success: function(msg)
            {
                $('body').append('<div id="formUpdateUser" title="Modification de votre profil" style="display:none">'+msg+'</div>');
                $("#formUpdateUser").dialog({
                    autoOpen: true,
                    show: {effect: "blind", duration: 1000 }, 
                    hide: {effect: "explode", duration: 1000 },
                    modal: true,
                    height: 400,
                    width: 600,
                    buttons: {
                        "Modifier": function() {
                            $( this ).dialog( "close" );
                            thisUser.val.firstName = $("#firstName").val();
                            thisUser.val.lastName = $("#lastName").val();
                            thisUser.val.mail = $("#mail").val();
                            thisUser.val.year = $("#year").val();
                            thisUser.val.yearName = $("#year option:selected").text();
                            thisUser.val.availability = $("#availability").val();
                            thisUser.val.availabilityName = "Disponible";
                            if($("#availability").val() == 1)
                            {
                                thisUser.val.availabilityName = "Indisponible";
                            }
                            /*$.ajax({
                                type: "POST",
                                url: "user/"+id,
                                data: 'updateUser='+JSON.stringify(thisUser.val),
                                success: function(msg){
                                    noty({timeout: 3000,text: "La modification a été prise en compte",type: 'success'});
                                },
                                error: function(msg){
                                    noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
                                }   
                            });*/
                            thisUser.displayUser();
                        },
                        "Annuler": function() {
                            $( this ).dialog( "close" );
                        }
                    }
                });
                $('#formUpdateUser').on( "dialogclose", function() {
                    $("#formUpdateUser").remove();
                });
                $("#firstName").val(thisUser.val.firstName);
                $("#lastName").val(thisUser.val.lastName);
                $("#mail").val(thisUser.val.mail);
                $("#year").val(thisUser.val.year);
                //$( "#year" ).val(thisUser.val.yearName);
                $("#availability").val([thisUser.val.availability]);
                $( "#formUpdateUser" ).dialog( "open" );
            }
        });
         //affichage du form update user
        $("#formUpdateUser").dialog({
            autoOpen: false,
            show: {effect: "blind", duration: 1000 }, 
            hide: {effect: "explode", duration: 1000 }, 
            modal: true,
            height: 400,
            width: 600
        });
    }
    
};


$(document).ready(function(){

    /**********************GESTION DU PROFIL*******************************/    
   
	$( "#openformUpdateUser" ).click(function() {
     thisUser.displayFormUpdate();
    });
    
/**********************GESTION DES COMPETENCES*******************************/ 

    //modal de l'arbre de compétences
    $("#updateSkillTreeUserModal").dialog({
    	autoOpen: false,
    	show: {effect: "blind", duration: 1000 }, 
        hide: {effect: "explode", duration: 1000 },
    	modal: true,
    	height: 800,
    	width: 800,
        buttons: 
        {
            "Proposer une compétence": function() {
                if(nodeSelect)
                {
                    $( this ).dialog( "close" );
                    $( "#proposeSkillUser" ).dialog( "open" );
                    $("#nameSkillParent").text(nodeSelect.name);
                }
                else
                {
                    alert("Veuillez selectionner une compétence parent");
                }
            },
            "sauvegarder et fermer":function(){$( this ).dialog( "close" );}
        },
    });

    // ouverture de la modal affectation compétence
    $( "#openUpdateSkillTreeUser" ).click(function() {
      $( "#updateSkillTreeUserModal" ).dialog( "open" );
        });
   
    $('#updateSkillTreeUserModal').on( "dialogclose", function() {
        thisUser.displaySkill();
    });

    //recherche dans l'arbre
    $("#searchSkillTree").keyup(function(){
        $(".jqtree-title").css('color','#666666');
        $(".jqtree-title").css('text-decoration','none');
        if($("#searchSkillTree").val() != "")
        {
            $('.jqtree-element').each(function(){
                var s= $(this).text().toLowerCase();
                if(s.indexOf($('#searchSkillTree').val().toLowerCase()) != -1)
                {
                    $(this).find(".jqtree-title").css('color','red');
                    $(this).find(".jqtree-title").css('text-decoration','underline');
                }
            });
        }
    });

    //dessine arbre de compétences
    $('#updateSkillTreeUser').tree({
        autoOpen: true,
        selectable: true,
        data: [
                {
                    label: 'Chatons ', id:1, note:0, 
                    children: [
                        { label: 'Qui dorment', id:2, note:0 }, 
                        { label: 'Qui font des bétisent', id:3, note:0,
                            children: [
                                { label: 'Grimpent aux rideaux', id:4, note:0 }, 
                                { label: 'Qui font caca dans le lit', id:5, note:0  }]  
                        }]
                }, 
                { 
                    label: 'Chien', id:6, note:0, 
                    children: [
                        { label: 'de chasse', id:7, note:0  } ,
                        { label: 'de promenade', id:8, note:0  } 
                    ] 
                }
            ],
           
        onCreateLi: function(node, $li) {
            node.note = getNote(node.id);
           
         	var star = '';
         	for(var i=0;i<node.note;i++)
         	{
         		star += '<img src="img/star.png" class="star">';
         	}
            $li.find('.jqtree-title').after('<span class="icon" id="nodeSkillTree'+node.id+'">'+star+'</span>');
        }
    });

    //modification de l'arbre de compétence
    // affectation et évaluation de compétence
    $('#updateSkillTreeUser').bind(
        'tree.dblclick',
        function(event) {
            var node = event.node;
            var star = '';
            node.note++;
            if(node.note > 5)
            {
            	node.note = 0;
            }
         	for(var i=0;i<node.note;i++)
         	{
         		star += '<img src="img/star.png" class="star">';
         	}
            $('#nodeSkillTree'+node.id).html(star);

            thisUser.skills = jQuery.parseJSON($('#updateSkillTreeUser').tree('toJson'));
            /*$.ajax({
                type: "POST",
                url: "user/skills",
                data: 'skilltree='+$('#updateSkillTreeUser').tree('toJson')+'&idUser='+thisUser.id,
                success: function(msg){
                    noty({timeout: 3000,text: "L'arbre de compétence a été modifié",type: 'success'});
                },
                error: function(msg){
                    noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
                }   
            });*/
        }
    );
    
    $('#updateSkillTreeUser').bind(
        'tree.select',
        function(event) {
            if (event.node) {
                nodeSelect = event.node;
            }
            else {
                nodeSelect = null;
            }
        }
    );

    //modal proposer une compétence
    $("#proposeSkillUser").dialog({
        autoOpen: false,
        show: {effect: "blind", duration: 1000 }, 
        hide: {effect: "explode", duration: 1000 },
        modal: true
    });

    //submit propose compétence
    $( "#buttonProposeSkill" ).click(function() {
        if($('#inputProposeSkill').val() != "")
        {
            $.ajax({
                type: "POST",
                url: "skill/add",
                data: 'proposeSkill='+$('#inputProposeSkill').val()+'&idParents='+nodeSelect.id,
                success: function(msg){
                    $( "#updateSkillTreeUserModal" ).dialog( "close" );
                    noty({timeout: 3000,text: "La modification a été prise en compte",type: 'success'});
                },
                error: function(msg){
                    noty({timeout: 3000,text: "Un problème est apparu, l'action n'a pas été sauvegardée",type: 'error'});
                }   
            });
        }
    });

});



