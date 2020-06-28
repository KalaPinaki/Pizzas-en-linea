
<%--
MenuPizzas.jsp

EIF209 - Programación 4 – Proyecto #2
Junio 2020

Autores:
- 116630575 Dafhnne Alfaro
- 304950273 Leonardo Baldares
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Menú</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/tablas.css" rel="stylesheet" type="text/css"/>
        <script src="js/responsive-nav.js" type="text/javascript"></script>
        <script src="js/scriptCliente.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
        <script src="js/logOutScript.js" type="text/javascript"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>

    <body onload="cargaInicial()">
        <div>
            <div>

                <header>
                    <nav class="nav-collapse">
                        <ul>
                            <li class="menu-item active"><a href="#pizzas" data-scroll>Pizzas</a></li>
                            <li class="menu-item"><a href="#extras" data-scroll>Extras</a></li>
                            <li class="menu-item"><a href="#complementos" data-scroll>Complementos</a></li>
                            <li class="menu-item"><a href="#bebidas" data-scroll>Bebidas</a></li>
                            <li class="menu-item"><a href="#carrito" data-scroll>Carrito</a></li>
                            <li class="salir"><a href="javascript:void(0);" onclick="logOut()">Salir</a></li>
                        </ul>
                    </nav>                                                                                  
                </header> 


                <section id="pizzas">
                    <h1>PIZZAS</h1>

                    <table class="tablaPizzas">
                        <tbody id="tPizzas">

                        </tbody>
                    </table>
                    <p>&nbsp;</p>
                    <p style="text-align: center">Nota: El precio de la pizza varia según el tamaño(grande +¢1500, mediana +¢1000, pequeña +¢800)</p>
                </section>

                <section id="extras">
                    <h1>EXTRAS</h1>
                    <table class="tablaExtras">
                        <tbody id="tExtras">

                        </tbody>
                    </table>
                </section>

                <section id="complementos">
                    <h1>COMPLEMENTOS</h1>
                    <table class="tablaComplementos">
                        <tbody id="tComplementos">

                        </tbody>
                    </table>
                </section>

                <section id="bebidas">
                    <h1>BEBIDAS</h1>
                    <table class="tablaBebidas">
                        <tbody id="tBebidas">

                        </tbody>
                    </table>
                </section>

                <section id="carrito">
                    <h1>CARRITO</h1>
                    <table class="tablaOrden">
                        <thead>
                            <tr>
                                <th style="width: 180px;">Descripción</th>
                                <th style="width: 90px;">Precio</th>

                                <th style="width: 90px;">Cant.</th>
                                <th style="width: 120px;">Total</th>
                                <th style="width: 48px;">&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody id="tOrden"></tbody>
                        <tfoot>
                            <tr>
                                <td colspan="3" class="c2b">Total general:</td>
                                <td id="totalGeneral" class="c2c" />
                                <td>
                                    <button type="button" class="fa fa-trash" style="font-size:15px;color:crimson" onclick="CancelaCompra()"> Cancelar</button>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                    <p>&nbsp;</p>
                    <p style="text-align: center">
                        <label> Metodo de Pago: </label>
                        <select id="metodo" style="text-align: left">
                            <option value="Contado">Contado</option> 
                            <option value="Tarjeta" >Tarjeta</option>
                        </select>
                    </p>
                    <p>&nbsp;</p>
                    <p style="text-align: center;">
                        <button type="button" class="fa fa-money" style="font-size:25px;color:crimson" id="orden1" onclick="ConfirmaCompra()" value="1"> Comprar</button>
                    </p>
                </section>

                <script src="js/fastclick.js" ></script>
                <script src="js/scroll.js" ></script>
                <script src="js/fixed-responsive-nav.js" ></script>

            </div>
        </div>
    </body>
</html>
