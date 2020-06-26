<%@page import="Model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<a href="templateOptions.jsp"></a>
<html>
    <head>
        <meta charset="UTF-8" />
        <%response.setHeader("cache-control", "no-cache, no-store, must-revalidate");%>

        <%
            HttpSession sesion = request.getSession(true);
            long transcurrido = System.currentTimeMillis() - sesion.getLastAccessedTime();
            if (transcurrido > (1000 * 600)) {
                request.getRequestDispatcher("login.jsp?Message=3").forward(request, response);
            }
            //aqui iría enviarlo al Index..pero siempre lo envia ahí cuando se pasa el tiempo
            if (request.getSession(true).getAttribute("ClientData") == null) {
                request.getRequestDispatcher("login.jsp?Message=3").forward(request, response);
            }

        %>
        <link href="css/TemplateMenuCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="UserMenu.jsp">Inicio</a>
            <%                Client client = (Client) request.getSession(true).getAttribute("ClientData");

                //userBean = (User) session.getAttribute("SystemEntry");....no se lo del bean
                if (client.getUser().getRole() == 1) {
            %>
            <a href="CheckClient.jsp">Apertura de cuenta</a>
            <a href="Deposit.jsp">Depósito</a>
            <a href="Withdraw1.jsp">Retiro</a>
            <a href="Transfer1.jsp">Transferencia en Cajas</a>
            <a href="Accreditation.jsp">Acreditacion de intereses</a>
            <a href="ListAccountMovements.jsp">Consulta de cuentas y movimientos</a>
            <a href="AddFavoriteAcc.jsp">Vinculación de cuentas</a>
            <a href="RemoteTransferency1.jsp">Transferencia remota</a>
            <%
            } else {
            %>
            <a href="ListAccountMovements.jsp">Consulta de cuentas y movimientos</a>
            <a href="AddFavoriteAcc.jsp">Vinculación de cuentas</a>
            <a href="RemoteTransferency1.jsp">Transferencia remota</a>
            <%
                }
            %>
            <a style="float:right" href="LogOut">Log Out</a>

        </div>
    </body>
</html>
