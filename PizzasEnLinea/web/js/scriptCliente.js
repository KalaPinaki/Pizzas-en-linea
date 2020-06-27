var pizzas = [];
var bebidas = [];
var complementos = [];
var extras = [];

var indiceExtras = 0;
var indiceComplementos = 0;
var indicePizza = 0;
var indiceBebidas = 0;


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
            select.setAttribute("id", "tamaño"+indicePizza);
            nuevaCelda.appendChild(select);

            var opcion = document.createElement("option");
            opcion.setAttribute("value", "Grande");
            var show = document.createTextNode("Grande");
            opcion.appendChild(show);
            select.appendChild(opcion);
            
            var opcion = document.createElement("option");
            opcion.setAttribute("value", "Mediano");
            var show = document.createTextNode("Mediano");
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
            btn.innerHTML = "<i onclick='AgregaPizza();'>Agregar al carrito</i>";
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

function AgregarPizza(){
    getJSON2();
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
            btn.innerHTML = "<i onclick='AgregaComplemento();'>Agregar al carrito</i>";
            nuevaCelda.appendChild(btn);

            var fila = {
                nombreB: fila.nombre,
                precioB: fila.precio
            };
            complementos.push(fila);
            indiceComplementos += 1;
        });
    }
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
            btn.innerHTML = "<i onclick='AgregaBebida();'>Agregar al carrito</i>";
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
            btn.innerHTML = "<i onclick='AgregaExtra();'>Agregar al carrito</i>";
            nuevaCelda.appendChild(btn);

            var fila = {
                nombreB: fila.nombre,
                precioB: fila.precio
            };
            extras.push(fila);
            indiceExtras += 1;
        });
    }
}
////////////////////////////////////////////////////////////////////////////////  factura