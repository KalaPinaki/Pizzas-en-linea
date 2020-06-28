function login() {
    var data = new FormData();
    var user = document.getElementById('user').value;
    var password = document.getElementById('pass').value;

    data.append("user", user);
    data.append("password", password);

    getJSONv2("ServicioUsuario?opcion=1", data, resultado);
}

function getJSONv2(url, data, callback) {//llama al servidor para guardar la factura y muestra una confirmacion
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}

function resultado(datos) {

    if (!datos.result === "funciona") {
        alert(datos.result);
    } else {
        if(datos.rol === "true"){
            window.location = "menuAdmin.jsp";
        }else{
            window.location = "menuPizzas.jsp";
        }
    }
}


function confirmarCambio() {
    var data = new FormData();
    var user = document.getElementById('cedula').value;
    var password = document.getElementById('newPass').value;

    data.append("user", user);
    data.append("password", password);

    getJSONv2("ServicioUsuario?opcion=2", data, resultado2);
}

function resultado2(datos) {
    alert(datos.result);
    window.location.reload();
}

//////////////////////////////////////////////////////////////////


// When the user clicks the button, open the modal 
function olvidaContraseña() {
    var modal = document.getElementById("cambiaPass");
    var btn = document.getElementById("olvido");
    var span = document.getElementsByClassName("menuCambiar")[0];

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

function cancelar() {
    
    span.onclick = function () {
        modal.style.display = "none";
    }
}



function showPassword(contraseña) {
    var x = document.getElementById(contraseña);
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}



function registrar() {
    var modal = document.getElementById("registrar");
    var btn = document.getElementById("registro");
    var span = document.getElementsByClassName("menuRegistro")[0];

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}


function confirmarRegistro() {
    var data = new FormData();
    var name = document.getElementById('nombre').value;
    var surname = document.getElementById('apellidos').value;
    var cedula = document.getElementById('ced').value;
    var direccion = document.getElementById('direccion').value;
    var pass = document.getElementById('pass2').value;
    var telefono = document.getElementById('telefono').value;

    data.append("nombre", name);
    data.append("apellidos", surname);
    data.append("cedula", cedula);
    data.append("direccion", direccion);
    data.append("password", pass);
    data.append("telefono", telefono);

    getJSONv2("ServicioUsuario?opcion=3", data, resultado2);
}

function cancelar() {
    window.location.reload();
}


//////////////////////////////////////////////////////////////////////