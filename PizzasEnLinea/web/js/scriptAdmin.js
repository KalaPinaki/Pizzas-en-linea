var pizzas = [];
var bebidas = [];
var complementos = [];
var extras = [];
var pedidos = [];

var indiceExtras = -1;
var indiceComplementos = -1;
var indicePizza = 0;
var indiceBebidas = -1;
var indicePedidos = 0;


function cargaInicialAdmin() {
    cargaPizzas();
    cargaBebidas();
    cargaComplementos();
    cargaExtras();
    cargaPedidos();
}

function reload() {
    location.reload();//recarga el documento actual
}

function mostrarMensaje(mensaje) {//recibe un String (el mensaje de exito/error al procesar) 
    alert(mensaje.result);
    location.reload();//recarga el documento actual
}

function mostrarMensajesCRUD(mensaje) {
    if (mensaje.result !== "Exito") {
        alert(mensaje.result);
    } else {
        alert(mensaje.result);
        location.reload();//recarga el documento actual
    }
}

function getJSON2(url, callback) {
    fetch(url).then((result) => {
        return result.json();
    }).then(callback);
}

function getJSONv2(url, data, callback) {//llama al servidor para guardar la factura y muestra una confirmacion
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}

//////////////////////////////////////////////////////////////////////////////// PIZZAS
function cargaPizzas() {
    getJSON2('ServicioPizza?opcion=1', cargarTablaMenuPizzas);
}

function cargarTablaMenuPizzas(datos) {
    var refTabla = document.getElementById('tPizzas');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.lista_pizzas.forEach(function (fila, i, arreglo) {
            var indice = refTabla.rows.length;//calcula cuantas filas que hay ahorita en la tabla...para identificar cada item de la tabla
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            var ingredientes = fila.ingredientes;
            var num = 0;
            var ingre = "";
            ingredientes.forEach(function (fila2) {
                if (num !== ingredientes.length - 1) {
                    ingre += fila2.nombre + ", ";
                } else {
                    ingre += fila2.nombre;
                }
                num++;
            });
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Ingredientes: \
                                    " + ingre + "\n Precio: " + fila.precio;

            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indicePizza", indice);
            btn.innerHTML = "<i onclick='EliminarPizza();'>Eliminar Pizza</i>";
            nuevaCelda.appendChild(btn);

            var fila = {
                nombreP: fila.nombre,
                ingredintesP: fila.ingredintes,
                precioP: fila.precio
            };
            pizzas.push(fila);
            //indicePizza += 1;
        });
    }
}

function EliminarPizza() {
    eliminarPizza(JSON.parse(event.target.parentNode.getAttribute("indicePizza")));
}

function eliminarPizza(fila) {
    console.log("Eliminando fila: " + fila);
    var refTabla = document.getElementById("tPizzas");
    if (refTabla) {
        var nombreP = pizzas[fila].nombreP;

        // Elimina la fila de la tabla de datos y de la tabla mostrada
        // en la página.
        getJSON2('ServicioPizza?opcion=2' + '&nomPizza=' + nombreP, mostrarMensaje);
    }
}

//////////////////////////////////////////////////////////////////////////////// Complementos

function cargaComplementos() {
    getJSON2('ServicioComplementos?opcion=1', cargarTablaMenuComplementos);
}

function cargarTablaMenuComplementos(datos) {
    var refTabla = document.getElementById('tComplementos');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Complementos.forEach(function (fila, i, arreglo) {
            var indice = refTabla.rows.length;//calcula cuantas filas que hay ahorita en la tabla...para identificar cada item de la tabla
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Precio: " + fila.precio;

            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceComplemento", indice);
            btn.innerHTML = "<i onclick='EliminarComplemento();'>Eliminar Complemento</i>";
            nuevaCelda.appendChild(btn);

            //boton para actualizar ese complemento
            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("id", "actualizarCompl" + indice);
            btn.setAttribute("indiceComplemento", indice);
            btn.innerHTML = "<i onclick='ActualizarComplemento();'>Actualizar Complemento</i>";
            nuevaCelda.appendChild(btn);


            var fila = {
                nombreB: fila.nombre,
                precioB: fila.precio
            };
            complementos.push(fila);

//            indiceComplementos += 1;
        });
    }
}


function EliminarComplemento() {
    eliminarComplemento(JSON.parse(event.target.parentNode.getAttribute("indiceComplemento")));
}

function eliminarComplemento(fila) {
    console.log("Eliminando fila: " + fila);
    var refTabla = document.getElementById("tComplementos");
    if (refTabla) {
        var nombreB = complementos[fila].nombreB;
        getJSON2('ServicioComplementos?opcion=2' + '&nomComplement=' + nombreB, mostrarMensaje);
    }
}

function ActualizarComplemento() {
    actualizarComplementos(JSON.parse(event.target.parentNode.getAttribute("indiceComplemento")));
}

function actualizarComplementos(fila) {
    console.log("Actualizando fila: " + fila);
    var refTabla = document.getElementById("tComplementos");
    if (refTabla) {
        var nombreC = complementos[fila].nombreB;
        var precioC = complementos[fila].precioB;
        document.getElementById("nombreC").setAttribute("value", nombreC);
        document.getElementById("precioC").setAttribute("value", precioC);
        indiceComplementos = fila; //actualiza el indice
        modelComplement("actualizarCompl" + indiceComplementos);
    }
}

function modelComplement(botonTrigger) {
    var modal = document.getElementById("agregarComplementos");//division con clase modal
    if (botonTrigger === null) {
        var btn = document.getElementById("complementBtn");//noombre del boton trigger
    } else {
        var btn = document.getElementById(botonTrigger);//noombre del boton de insertar...por defaul
    }
    var span = document.getElementsByClassName("ComplementSpan")[0]; //span class

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
            //limpiar los inputs
            document.getElementById("nombreC").setAttribute("value", "");
            document.getElementById("precioC").setAttribute("value", null);
        }
    }
}


function confirmarGenericoComplementos() {
    var data = new FormData();
    var nombreCom = document.getElementById('nombreC').value;
    var precioCom = document.getElementById('precioC').value;
    data.append("nombreCom", nombreCom);
    data.append("precioCom", precioCom);
    //si actualiza o inserta
    if (indiceComplementos === -1) {//inserta
        getJSONv2("ServicioComplementos?opcion=3", data, mostrarMensajesCRUD);
    } else { //actualiza cualquier indice
        var antiguoNombre = complementos[indiceComplementos].nombreB;
        data.append("oldName", antiguoNombre);
        indiceComplementos = -1;
        getJSONv2("ServicioComplementos?opcion=4", data, mostrarMensajesCRUD);

    }
}


//////////////////////////////////////////////////////////////////////////////// bebidas
function cargaBebidas() {
    getJSON2('ServicioBebidas?opcion=1', cargarTablaMenuBebidas);
}

function cargarTablaMenuBebidas(datos) {
    var refTabla = document.getElementById('tBebidas');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Bebidas.forEach(function (fila, i, arreglo) {
            var indice = refTabla.rows.length;//calcula cuantas filas que hay ahorita en la tabla...para identificar cada item de la tabla
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Precio: " + fila.precio;

            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceBebidas", indice);
            btn.innerHTML = "<i onclick='EliminarBebida();'>Eliminar Bebida</i>";
            nuevaCelda.appendChild(btn);

            //boton para actualizar esa bebida
            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("id", "actualizarBeb" + indice);
            btn.setAttribute("indiceBebida", indice);
            btn.innerHTML = "<i onclick='ActualizarBebidas();'>Actualizar Bebida</i>";
            nuevaCelda.appendChild(btn);

            var fila = {
                nombreD: fila.nombre,
                precioD: fila.precio
            };
            bebidas.push(fila);
//            indiceBebidas += 1;
        });
    }
}

function EliminarBebida() {
    eliminarBebida(JSON.parse(event.target.parentNode.getAttribute("indiceBebida")));
}

function eliminarBebida(fila) {
    console.log("Eliminando fila: " + fila);
    var refTabla = document.getElementById("tBebidas");
    if (refTabla) {
        var nombreC = bebidas[fila].nombreD;
        getJSON2('ServicioBebidas?opcion=2' + '&nomBeb=' + nombreC, mostrarMensaje);
    }
}

function ActualizarBebidas() {
    actualizarBebidas(JSON.parse(event.target.parentNode.getAttribute("indiceBebida")));
}

function actualizarBebidas(fila) {
    console.log("Actualizando fila: " + fila);
    var refTabla = document.getElementById("tBebidas");
    if (refTabla) {
        var nombreD = bebidas[fila].nombreD;
        var precioD = bebidas[fila].precioD;
        document.getElementById("nombreD").setAttribute("value", nombreD);
        document.getElementById("precioD").setAttribute("value", precioD);
        indiceBebidas = fila; //actualiza el indice
        modelDrink("actualizarBeb" + fila);
    }
}


// When the user clicks the button, open the modal 
function modelDrink(botonTrigger) {

    var modal = document.getElementById("agregarBebidas");
    if (botonTrigger === null) {
        var btn = document.getElementById("drinkBtn");//noombre del boton trigger
    } else {
        var btn = document.getElementById(botonTrigger);//noombre del boton de insertar...por defaul
    }
    var span = document.getElementsByClassName("DrinkSpan")[0]; //span class

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
            //limpiar los inputs
            document.getElementById("nombreD").setAttribute("value", "");
            document.getElementById("precioD").setAttribute("value", null);
        }
    }
}


function confirmarGenericoBebidas() {
    var data = new FormData();
    var nombreD = document.getElementById('nombreD').value;
    var precioD = document.getElementById('precioD').value;
    data.append("nombreD", nombreD);
    data.append("precioD", precioD);
    //si actualiza o inserta
    if (indiceBebidas === -1) {//inserta
        getJSONv2("ServicioBebidas?opcion=3", data, mostrarMensajesCRUD);
    } else { //actualiza cualquier indice
        var antiguoNombre = bebidas[indiceBebidas].nombreD;
        data.append("oldName", antiguoNombre);
        indiceBebidas = -1;
        getJSONv2("ServicioBebidas?opcion=4", data, mostrarMensajesCRUD);

    }
}

//////////////////////////////////////////////////////////////////////////////// Extras


function cargaExtras() {
    getJSON2('ServicioExtras?opcion=1', cargarTablaMenuExtras);
}

function cargarTablaMenuExtras(datos) {
    var refTabla = document.getElementById('tExtras');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Ingredientes.forEach(function (fila, i, arreglo) {
            var indice = refTabla.rows.length;//calcula cuantas filas que hay ahorita en la tabla...para identificar cada item de la tabla
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Precio: " + fila.precio;

            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceExtras", indice);
            btn.innerHTML = "<i onclick='EliminarExtras();'>Eliminar Extra</i>";
            nuevaCelda.appendChild(btn);

            //boton para actualizar ese extra
            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("id", "actualizar" + indice);
            btn.setAttribute("indiceExtras", indice);
            btn.innerHTML = "<i onclick='ActualizarExtras();'>Actualizar Extra</i>";
            nuevaCelda.appendChild(btn);

            var fila = {
                nombreB: fila.nombre,
                precioB: fila.precio
            };
            extras.push(fila);
//            indiceExtras += 1;
        });
    }
}

function EliminarExtras() {
    eliminarExtras(JSON.parse(event.target.parentNode.getAttribute("indiceExtras")));
}

function eliminarExtras(fila) {
    console.log("Eliminando fila: " + fila);
    var refTabla = document.getElementById("tExtras");
    if (refTabla) {
        var nombreC = extras[fila].nombreB;
        getJSON2('ServicioExtras?opcion=2' + '&nomExt=' + nombreC, mostrarMensaje);
    }
}

function ActualizarExtras() {
    actualizarExtras(JSON.parse(event.target.parentNode.getAttribute("indiceExtras")));
}

function actualizarExtras(fila) {
    console.log("Actualizando fila: " + fila);
    var refTabla = document.getElementById("tExtras");
    if (refTabla) {
        var nombreC = extras[fila].nombreB;
        var precioC = extras[fila].precioB;
        console.log(typeof (precioC));
        document.getElementById("nombreE").setAttribute("value", nombreC);
        document.getElementById("precioE").setAttribute("value", precioC);
        indiceExtras = fila; //actualiza el indice
        modelExtra("actualizar" + fila);
    }
}

// When the user clicks the button, open the modal 
function modelExtra(botonTrigger) {
    var modal = document.getElementById("agregarExtras");
    if (botonTrigger === null) {
        var btn = document.getElementById("ExtraBtn");//noombre del boton trigger
    } else {
        var btn = document.getElementById(botonTrigger);//noombre del boton de insertar...por defaul
    }
    var span = document.getElementsByClassName("ExtraSpan")[0]; //span class

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
            //limpiar los inputs
            document.getElementById("nombreE").setAttribute("value", "");
            document.getElementById("precioE").setAttribute("value", null);
        }
    }
}


function confirmarGenerico() {
    var data = new FormData();
    var nombreEx = document.getElementById('nombreE').value;
    var precioEx = document.getElementById('precioE').value;
    data.append("nombreEx", nombreEx);
    data.append("precioEx", precioEx);
    //si actualiza o inserta
    if (indiceExtras === -1) {//inserta
        getJSONv2("ServicioExtras?opcion=3", data, mostrarMensajesCRUD);
    } else { //actualiza cualquier indice
        var antiguoNombre = extras[indiceExtras].nombreB;
        data.append("oldName", antiguoNombre);
        indiceExtras = -1;
        getJSONv2("ServicioExtras?opcion=4", data, mostrarMensajesCRUD);

    }
}



////////////////////////////////////////////////////////////////////////////////  factura

function cargaPedidos() {
    getJSON2('ServicioConfirmaOrden?opcion=2', cargarTablaPedidos);
}


function cargarTablaPedidos(datos) {
    console.log(datos);
    var refTabla = document.getElementById('tPedidos');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Ordenes.forEach(function (fila, i, arreglo) {
            var indice = refTabla.rows.length;//calcula cuantas filas que hay ahorita en la tabla...para identificar cada item de la tabla
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila["num orden"];
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila["ced cliente"];
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila["nomb cliente"];
            nuevaCelda = nuevaFila.insertCell(-1);
            if (fila.estado === 0) {//En proceso
                nuevaCelda.innerText = "En proceso";
            } else if (fila.estado === 1) {
                nuevaCelda.innerText = "En ruta";
            } else {//2. entregado
                nuevaCelda.innerText = "Entregado";
            }

            //obtener las extras
            var extras = "";
            fila.extras.forEach(function (ext, i, arreglo) {
                extras += ext.nombre + ", ";
            });
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = extras;

            var pizzas = "";
            fila.pizzas.forEach(function (piz, i, arreglo) {
                pizzas += piz.nombre + ", " + formatoMoneda(piz.precio) + "\n";
            });
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = pizzas;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila["fecha"];
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila["metodo pago"];
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = formatoMoneda(fila["precio"]);

            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceOrden", indice);
            btn.setAttribute("id", "actualizarOrden" + indice);
            btn.innerHTML = "<i onclick='ActualizarOrden();'>Actualizar Orden</i>";
            nuevaCelda.appendChild(btn);

            var fila = {
                numOrden: fila["num orden"],
                cedula: fila["ced cliente"],
                indice: indice,
                estado: fila.estado
            };

            pedidos.push(fila);
        });
    }
}

function ActualizarOrden() {
    actualizarOrden(JSON.parse(event.target.parentNode.getAttribute("indiceOrden")));
}

function actualizarOrden(fila) {
    console.log("Actualizando fila: " + fila);
    var refTabla = document.getElementById("tPedidos");
    if (refTabla) {
        var estado = pedidos[fila].estado;
        document.getElementById("estadoP").setAttribute("value", estado);
        indicePedidos = fila;
        modelActPedido("actualizarOrden" + fila);
    }
}

function modelActPedido(botonTrigger) {
    var modal = document.getElementById("updateOrden");
    var btn = document.getElementById(botonTrigger);//noombre del boton trigger
    var span = document.getElementsByClassName("PedidosSpan")[0]; //span class

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
            //limpiar los inputs
            document.getElementById("estadoP").setAttribute("value", "0");
        }
    }
}


function confirmarEstadoOrden() {
    var data = new FormData();
    var num = pedidos[indicePedidos].numOrden;
    var estado = document.getElementById('estadoP').value;
    data.append("numOrden", num);
    data.append("estado", estado);
    //si actualiza o inserta
    indicePedidos = 0;
    getJSONv2('ServicioConfirmaOrden?opcion=3', data, mostrarMensajesCRUD);

}


////////////////////////////////////////////////////////////////////////////////    Otras

//no funciona.... -.-
function cancelarSpan() {
    span.onclick = function () {
        modal.style.display = "none";
    }
}

function formatoMoneda(valor) {

    // https://www.fileformat.info/info/unicode/char/20a1/index.htm
    // 20A1(16) = 8353(10)

    return String.fromCharCode(8353) + numeral(valor).format(" 0,0.00");
}