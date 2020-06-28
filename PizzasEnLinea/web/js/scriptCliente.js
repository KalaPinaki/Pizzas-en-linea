var pizzas = [];
var bebidas = [];
var complementos = [];
var extras = [];
var Ordenes = new Array();
var pizzasOrden = [];
var extrasOrden = [];


var indiceOrden = 0;
var indiceExtras = 0;
var indiceComplementos = 0;
var indicePizza = 0;
var indiceBebidas = 0;
var total = null;

function cargaInicial() {
    cargaPizzas();
    cargaBebidas();
    cargaComplementos();
    cargaExtras();
}


function getJSON2(url, callback) {
    fetch(url).then((result) => {
        return result.json();
    }).then(callback);
}

//////////////////////////////////////////////////////////////////////////////// PIZZAS
function cargaPizzas() {
    getJSON2('ServicioPizza', cargarTablaMenuPizzas);
}

function cargarTablaMenuPizzas(datos) {
    var refTabla = document.getElementById('tPizzas');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.lista_pizzas.forEach(function (fila, i, arreglo) {

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
            })
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Ingredientes: \
                                    (" + ingre + ")\n Precio: " + fila.precio;
            nuevaCelda = nuevaFila.insertCell(-1);
            var select = document.createElement("SELECT");
            select.setAttribute("id", "tamaño" + indicePizza);
            nuevaCelda.appendChild(select);
            var opcion = document.createElement("option");
            opcion.setAttribute("value", "Grande");
            var show = document.createTextNode("Grande");
            opcion.appendChild(show);
            select.appendChild(opcion);
            var opcion = document.createElement("option");
            opcion.setAttribute("value", "Mediana");
            var show = document.createTextNode("Mediana");
            opcion.appendChild(show);
            select.appendChild(opcion);
            var opcion = document.createElement("option");
            opcion.setAttribute("value", "Pequeña");
            var show = document.createTextNode("Pequeña");
            opcion.appendChild(show);
            select.appendChild(opcion);
            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indicePizza", indicePizza);
            btn.innerHTML = "<i onclick='AgregarPizza();'>Agregar al carrito</i>";
            nuevaCelda.appendChild(btn);
            var fila = {
                nombreP: fila.nombre,
                ingredintesP: fila.ingredintes,
                precioP: fila.precio,
            };
            pizzas.push(fila);
            indicePizza += 1;
        });
    }
}

function AgregarPizza() {
    AgregaPizza(JSON.parse(event.target.parentNode.getAttribute("indicePizza")));
}

function AgregaPizza(fila) {

    var Pizza = {
        indice: indicePizza,
        nombre: pizzas[fila].nombreP,
        ingrediantes: pizzas[fila].ingredientesP,
        precio: pizzas[fila].precioP,
        tamaño: document.getElementById("tamaño" + fila).value
    }

    if (Pizza.tamaño === "Grande") {
        Pizza.precio += 1500;
    }
    if (Pizza.tamaño === "Mediana") {
        Pizza.precio += 1000;
    }
    if (Pizza.tamaño === "Pequeña") {
        Pizza.precio += 800;
    }

    pizzasOrden.push(Pizza);

    AgregarOrden(pizzasOrden, extrasOrden);
}



//////////////////////////////////////////////////////////////////////////////// Complementos

function cargaComplementos() {
    getJSON2('ServicioComplementos', cargarTablaMenuComplementos);
}

function cargarTablaMenuComplementos(datos) {
    var refTabla = document.getElementById('tComplementos');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Complementos.forEach(function (fila, i, arreglo) {

            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Precio: " + fila.precio;
            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceComplemento", indiceComplementos);
            btn.innerHTML = "<i onclick='AgregarComplemento();'>Agregar al carrito</i>";
            nuevaCelda.appendChild(btn);
            var fila = {
                
                nombreC: fila.nombre,
                precioC: fila.precio
            };
            complementos.push(fila);
            indiceComplementos += 1;
        });
    }
}

function AgregarComplemento() {
    AgregaComplemento(JSON.parse(event.target.parentNode.getAttribute("indiceComplemento")));
}

function AgregaComplemento(fila) {
    var Complemento = {
        tipo: 'Complemento',
        nombre: complementos[fila].nombreC,
        precio: complementos[fila].precioC
    }
    extrasOrden.push(Complemento);

    AgregarOrden(pizzasOrden, extrasOrden);
}




//////////////////////////////////////////////////////////////////////////////// bebidas
function cargaBebidas() {
    getJSON2('ServicioBebidas', cargarTablaMenuBebidas);
}

function cargarTablaMenuBebidas(datos) {
    var refTabla = document.getElementById('tBebidas');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Bebidas.forEach(function (fila, i, arreglo) {

            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Precio: " + fila.precio;
            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceBebidas", indiceBebidas);
            btn.innerHTML = "<i onclick='AgregarBebida();'>Agregar al carrito</i>";
            nuevaCelda.appendChild(btn);
            var fila = {
                
                nombreB: fila.nombre,
                precioB: fila.precio
            };
            bebidas.push(fila);
            indiceBebidas += 1;
        });
    }
}


function AgregarBebida() {
    AgregaBebida(JSON.parse(event.target.parentNode.getAttribute("indiceBebidas")));
}

function AgregaBebida(fila) {
    var Bebida = {
        tipo: 'Bebida',
        nombre: bebidas[fila].nombreB,
        precio: bebidas[fila].precioB
    }
    extrasOrden.push(Bebida);

    AgregarOrden(pizzasOrden, extrasOrden);
}

//////////////////////////////////////////////////////////////////////////////// Extras

function cargaExtras() {
    getJSON2('ServicioExtras', cargarTablaMenuExtras);
}

function cargarTablaMenuExtras(datos) {
    var refTabla = document.getElementById('tExtras');
    if (refTabla) {
        refTabla.innerHTML = "";
        datos.Lista_Ingredientes.forEach(function (fila, i, arreglo) {

            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = fila.nombre + "\n  Precio: " + fila.precio;

            nuevaCelda = nuevaFila.insertCell(-1);
            var btn = document.createElement("button");
            btn.className = "btn";
            btn.setAttribute("indiceExtras", indiceExtras);
            btn.innerHTML = "<i onclick='AgregarExtra();'>Agregar al carrito</i>";
            nuevaCelda.appendChild(btn);
            var fila = {
                
                nombreE: fila.nombre,
                precioE: fila.precio
            };
            extras.push(fila);
            indiceExtras += 1;
        });
    }
}

function AgregarExtra() {
    AgregaExtra(JSON.parse(event.target.parentNode.getAttribute("indiceExtras")));
}

function AgregaExtra(fila) {
    var Extra = {
        tipo: 'Extra',
        nombre: extras[fila].nombreE,
        precio: extras[fila].precioE
    }
    extrasOrden.push(Extra);

    AgregarOrden(pizzasOrden, extrasOrden);
}


////////////////////////////////////////////////////////////////////////////////  factura

function AgregarOrden(datosPizzas, datosExtras) {
    var refTabla = document.getElementById('tOrden');
    if (refTabla) {
        refTabla.innerHTML = "";
        Ordenes = [];
        indiceOrden = 0;
        if (datosPizzas.length !== 0) {
            var nuevaFila;
            var nuevaCelda;
//            nuevaFila.innerHTML = "<tr><td colspan=\"5\"> <strong>Pizzas</strong> </d></tr>";
            for (var i = 0; i < datosPizzas.length; i++) {
                nuevaFila = refTabla.insertRow(-1);
                nuevaCelda = nuevaFila.insertCell(-1);
                nuevaCelda.innerText = datosPizzas[i].nombre + "\ntamaño: " + datosPizzas[i].tamaño;
                nuevaCelda = nuevaFila.insertCell(-1);
                nuevaCelda.innerText = "precio: " + formatoMoneda(datosPizzas[i].precio);

                nuevaCelda = nuevaFila.insertCell(-1);

                var input = document.createElement("input");
                input.setAttribute("type", "number");
                input.setAttribute("min", "1");
                input.value = "1";
                input.setAttribute("indiceOrden", indiceOrden);
                input.onchange = actualizarCampo;
                nuevaCelda.appendChild(input);

                nuevaCelda = nuevaFila.insertCell(-1);
                nuevaCelda.id = "total" + String(indiceOrden);
                nuevaCelda.innerText = formatoMoneda(datosPizzas[i].precio);

                nuevaCelda = nuevaFila.insertCell(-1);
                var btn = document.createElement("button");
                btn.className = "btn";
                btn.setAttribute("indiceOrden", indiceOrden);
                btn.innerHTML = "<i onclick='eliminarFila();'>elimina</i>";
                nuevaCelda.appendChild(btn);

                var datosProducto = {
                    indice: indiceOrden,
                    tipo: 'pizza',
                    nombre: datosPizzas[i].nombre,
                    precio: datosPizzas[i].precio,
                    cantidad: 1,
                    subtotal: datosPizzas[i].precio
                };
                indiceOrden += 1;
                Ordenes.push(datosProducto);
            }
        }
        if (datosExtras.length !== 0) {
            var nuevaFila;
            var nuevaCelda;
//            nuevaFila.innerHTML = "<tr><td colspan=\"5\"> <strong>Extras</strong> </td></tr>";

            for (var i = 0; i < datosExtras.length; i++) {
                nuevaFila = refTabla.insertRow(-1);
                nuevaCelda = nuevaFila.insertCell(-1);
                nuevaCelda.innerText = datosExtras[i].nombre;
                nuevaCelda = nuevaFila.insertCell(-1);
                nuevaCelda.innerText = "precio: " + formatoMoneda(datosExtras[i].precio);
                nuevaCelda = nuevaFila.insertCell(-1);

                var input = document.createElement("input");
                input.setAttribute("type", "number");
                input.setAttribute("min", "1");
                input.value = "1";
                input.setAttribute("indiceOrden", indiceOrden);
                input.onchange = actualizarCampo;
                nuevaCelda.appendChild(input);

                nuevaCelda = nuevaFila.insertCell(-1);
                nuevaCelda.id = "total" + indiceOrden;
                nuevaCelda.innerText = formatoMoneda(datosExtras[i].precio);

                nuevaCelda = nuevaFila.insertCell(-1);
                var btn = document.createElement("button");
                btn.className = "btn";
                btn.setAttribute("indiceOrden", indiceOrden);
                btn.innerHTML = "<i onclick='eliminarFila();'>elimina</i>";
                nuevaCelda.appendChild(btn);

                var datosProducto = {
                    indice: indiceOrden,
                    tipo: 'extra',
                    nombre: datosExtras[i].nombre,
                    precio: datosExtras[i].precio,
                    cantidad: 1,
                    subtotal: datosExtras[i].precio
                };
                indiceOrden += 1;
                Ordenes.push(datosProducto);
            }
        }

        actualizarTabla();
    }
}

function CancelaCompra() {
    window.location.reload();
}

function ConfirmaCompra() {
    var opcion = document.getElementById("orden1");
    var metodo = document.getElementById("metodo");

    getJSON2('ServicioConfirmaOrden?orden=' + JSON.stringify(Ordenes) +
            '&total=' + total + "&opcion=" + opcion.value + "&metodo=" +
            metodo.value, mensajeCompra);
}

function mensajeCompra(datos) {
    alert(datos.result);
    window.location.reload();
}

////////////////////////////////////////////////////////////////////////////////
function actualizarCampo() {
    var indice = event.target.getAttribute("indiceOrden");
    var nuevaCantidad = parseFloat(event.target.value);

    var item = Ordenes[indice];

    if (!isNaN(nuevaCantidad)) {
        var a = 0.1;
        var b = 1000.0;

        item.cantidad = Math.floor(100 * Math.max(a, Math.min(b, nuevaCantidad))) / 100;
        item.subtotal = item.precio * item.cantidad;
    }

    event.target.value = item.cantidad;

    actualizarTabla();
}

function actualizarTabla() {
    var refTabla = document.getElementById("tOrden");
    var refTotal = document.getElementById("totalGeneral");

    if (refTabla && refTotal) {
        var totalGeneral = 0.0;
        for (var i = 0; i < Ordenes.length; i++) {
            Ordenes[i].subtotal = Ordenes[i].precio * Ordenes[i].cantidad;

            var refSubtotal = document.getElementById("total" + Ordenes[i].indice);
            refSubtotal.innerText = formatoMoneda(Ordenes[i].subtotal);

            totalGeneral += Ordenes[i].subtotal;
        }
        total = totalGeneral;
        refTotal.innerText = formatoMoneda(totalGeneral);
    }
}


function eliminarFila() {
    eliminar(JSON.parse(event.target.parentNode.getAttribute("indiceOrden")));
}

function eliminar(fila) {
    console.log("Eliminando fila: " + fila);

    var refTabla = document.getElementById("tOrden");
    if (refTabla) {
        
        for(i=0; i<pizzasOrden.length; i++){
           if(pizzasOrden[i].nombre === Ordenes[fila].nombre){
               pizzasOrden.splice(i, 1);
           }
       }
       for(i=0; i<extrasOrden.length; i++){
           if(extrasOrden[i].nombre === Ordenes[fila].nombre){
               extrasOrden.splice(i, 1);
           }
       }
       
        Ordenes.splice(fila, 1);
        refTabla.deleteRow(fila);

        for (var i = fila; i < refTabla.rows.length; i++) {
            var refFila = refTabla.rows[i];


            Ordenes[i].indice = i;
            var campo = refFila.getElementsByTagName("input")[0];
            campo.setAttribute("indiceOrden", i);

            var refSubtotal = document.getElementById("total" + String(i + 1));


            refSubtotal.id = "total" + String(i);

            var btn = refFila.getElementsByTagName("I")[0].parentNode;
            btn.setAttribute("indiceOrden", i);
        }

        actualizarTabla();
    }
}

function formatoMoneda(valor) {

    // https://www.fileformat.info/info/unicode/char/20a1/index.htm
    // 20A1(16) = 8353(10)

    return String.fromCharCode(8353) + numeral(valor).format(" 0,0.00");
}