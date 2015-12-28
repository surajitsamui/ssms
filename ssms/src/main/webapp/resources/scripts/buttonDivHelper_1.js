/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function (){

    $('#__buttonContainer__').click(function(event){
    event.stopPropagation();
    if(event.target.id!='__buttonContainer__'){
        $('#__buttonContainer__').hide();
    }
});
});