/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function logOut(){
    getJSON('ServicioLogOut', resultadoOut);
}


function getJSON(source, callback) {
    fetch(source).then((r) => {
        return r.json();
    }).then(callback);
}

function resultadoOut(datos) {
    alert(datos.result);
    window.location = "index.jsp";
    
}
