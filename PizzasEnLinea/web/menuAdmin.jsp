<%-- 
    Document   : menuAdmin
    Created on : 26/06/2020, 07:13:09 PM
    Author     : leoba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Opciones de administrador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- -->
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="js/responsive-nav.js" type="text/javascript"></script>
        <script src="js/logOutScript.js" type="text/javascript"></script>
        <script src="js/scriptAdmin.js" type="text/javascript"></script>
    </head>
    <body onload="cargaInicialAdmin()">
        <div id="wrapper">
            <div id="contents">

                <header>
                    <nav class="nav-collapse">
                        <ul>
                            <li class="menu-item active"><a href="#pizzasA" data-scroll>Administrar <br> Pizzas</a></li>
                            <li class="menu-item"><a href="#extrasA" data-scroll>Administrar <br> Extras</a></li>
                            <li class="menu-item"><a href="#complementosA" data-scroll>Administrar <br> Complementos</a></li>
                            <li class="menu-item"><a href="#bebidasA" data-scroll>Administrar <br> Bebidas</a></li>
                            <li class="menu-item"><a href="#ordenesA" data-scroll>Administrar <br> Ordenes</a></li>
                            <li class="salir"><a href="javascript:void(0);" onclick="logOut()">Salir</a></li>
                        </ul>
                    </nav>                                                                                  
                </header> 



                <section id="pizzasA" class="pizzas">
                    <h1>Pizzas</h1>
                    <div id="listPizzas"><!-- Carga las pizzas actuales y puede elminarlas-->
                        <table class="tabla">
                            <tbody id="tPizzas">
                            </tbody>
                        </table>
                    </div>
                    <div id="AgregarPizzas"><!--Agrega Pizzas -->
                    </div>


                </section>


                <section id="extrasA" class="extras">
                    <div id="listarExtras">
                        <h1>EXTRAS</h1>
                        <table class="tabla">
                            <tbody id="tExtras">
                            </tbody>
                        </table>
                    </div>
                    <div id="insertExtra" class="insertExtra">
                        <p><!-- Trigger button to insert Extras-->
                            <br><button type="button" id="ExtraBtn" onclick="modelExtra(null)">Insertar Extra</button>
                        </p>
                    </div>
                    <div id="agregarExtras" class="modal">
                        <div class="modal-content-admin">
                            <span class="ExtraSpan">&times;</span>
                            <table class="newIngrediente">
                                <caption> Ingreso de Ingrediente</caption>
                                <tr>
                                    <td>Digite el nombre del ingrediente extra: </td>
                                    <td><input id="nombreE" type="text"></td>
                                </tr>
                                <tr>
                                    <td><br>Digite el costo: </td>
                                    <td><br><input id="precioE" type="number" min="0" ></td>
                                </tr>
                                <tr>
                                    <td style="text-align: right;"><br>
                                        <button type="button" id="boton" onclick="confirmarGenerico()">Aceptar</button>
                                    </td>
                                    <td style="text-align: center;"><br>
                                        <button type="button" id="boton" onclick="cancelarSpan()">Cancelar</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>

                </section>


                <section id="complementosA">
                    <div id="listarComplementos">
                        <h1>COMPLEMENTOS</h1>
                        <table class="tabla">
                            <tbody id="tComplementos">
                            </tbody>
                        </table>
                    </div>
                    <div id="insertComplemento" class="insertComplement">
                        <p><!-- Trigger button to insert Extras-->
                            <br><button type="button" id="complementBtn" onclick="modelComplement(null)">Insertar Complemento</button>
                        </p>
                    </div>
                    <div id="agregarComplementos" class="modal">
                        <div class="modal-content-admin">
                            <span class="ComplementSpan">&times;</span>
                            <table class="newComplement">
                                <caption> Ingreso de Complementos</caption>
                                <tr>
                                    <td>Digite el nombre del complemento: </td>
                                    <td><input id="nombreC" type="text"></td>
                                </tr>
                                <tr>
                                    <td><br>Digite el precio: </td>
                                    <td><br><input id="precioC" type="number" min="0" ></td>
                                </tr>
                                <tr>
                                    <td style="text-align: right;"><br>
                                        <button type="button" id="boton" onclick="confirmarGenericoComplementos()">Aceptar</button>
                                    </td>
                                    <td style="text-align: center;"><br>
                                        <button type="button" id="boton" onclick="cancelarSpan()">Cancelar</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </section>


                <section id="bebidasA">
                    <div id="listarBebidas">
                        <h1>BEBIDAS</h1>
                        <table class="tabla">
                            <tbody id="tBebidas"></tbody>
                        </table>
                    </div>
                    <div id="insertDrink" class="insertDrink">
                        <p><!-- Trigger button to insert Extras-->
                            <br><button type="button" id="drinkBtn" onclick="modelDrink(null)">Insertar Bebida</button>
                        </p>
                    </div>
                    <div id="agregarBebidas" class="modal">
                        <div class="modal-content-admin">
                            <span class="DrinkSpan">&times;</span>
                            <table class="newDrink">
                                <caption> Ingreso de Bebida</caption>
                                <tr>
                                    <td>Digite el nombre de la bebida </td>
                                    <td><input id="nombreD" type="text"></td>
                                </tr>
                                <tr>
                                    <td><br>Digite el precio: </td>
                                    <td><br><input id="precioD" type="number" min="0" ></td>
                                </tr>
                                <tr>
                                    <td style="text-align: right;"><br>
                                        <button type="button" id="boton" onclick="confirmarGenericoBebidas()">Aceptar</button>
                                    </td>
                                    <td style="text-align: center;"><br>
                                        <button type="button" id="boton" onclick="cancelarSpan()">Cancelar</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </section>


                <section id="ordenesA">
                    <div id="listarPedidos">
                        <h1>PEDIDOS</h1>
                        <table class="tablaPedidos">
                            <thead>
                                <tr>
                                    <th style="width: 10px;">#Orden</th>
                                    <th style="width: 20px;">ID Cliente</th>
                                    <th style="width: 60px;">Nombre Cliente</th>
                                    <th style="width: 60px;">Estado</th>
                                    <th style="width: 30px;">Extras</th>
                                    <th style="width: 30px;">Pizzas</th>
                                    <th style="width: 30px;">Fecha</th>
                                    <th style="width: 30px;">Metodo Pago</th>
                                    <th style="width: 30px;">Total</th>
                                    <th style="width: 30px;">Actualizar</th>
                                </tr>
                            </thead>
                            <tbody id="tPedidos"></tbody>
                        </table>
                    </div>
                    <div id="updateOrden" class="modal">
                        <div class="modal-content-admin">
                            <span class="PedidosSpan">&times;</span>
                            <table class="newPedido">
                                <caption> Datos del pedido</caption>
                                <tr>
                                    <td><br>Digite el estado del pedido </td>
                                    <td>
                                        <select id="estadoP">
                                            <option value="0">En proceso</option>
                                            <option value="1">En ruta</option>
                                            <option value="2">Entregado</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: right;"><br>
                                        <button type="button" id="boton" onclick="confirmarEstadoOrden()">Aceptar</button>
                                    </td>
                                    <td style="text-align: center;"><br>
                                        <button type="button" id="boton" onclick="cancelarSpan()">Cancelar</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </section>

                <script src="js/fastclick.js" ></script>
                <script src="js/scroll.js" ></script>
                <script src="js/fixed-responsive-nav.js" ></script>


            </div>
        </div>
    </body>
</html>
