conn = new Mongo();

db = conn.getDB("pizzeria");
db.dropDatabase()
db.createCollection('usuarios')
db.usuarios.insert({"nombre": "Georges", "apellidos":"Alfaro Salazar", "cedula": "105710421", "direccion": "San Jose", "contraseña": "admin", "telefono": "89104578","rol": true})
db.usuarios.insert({"nombre": "Samanta", "apellidos":"Alfaro Cruz", "cedula": "116630575" ,"direccion": "Heredia", "contraseña": "user123", "telefono": "85535569","rol": false})
db.usuarios.insert({"nombre": "Leonardo", "apellidos":"Baldares Gomez", "cedula": "304950273" ,"direccion": "Cartago", "contraseña": "user123", "telefono": "86575093","rol": false})

db.createCollection('pizzas')
db.pizzas.insert({"nombre": "Suprema", "ingredientes":[{"nombre": "pepperoni"}, {"nombre": "carne de res"},{"nombre": "carne de cerdo"},{"nombre": "chile dulce"},{"nombre": "hongos"},{"nombre": "cebolla"}],"precioBase": 2000.0})
db.pizzas.insert({"nombre": "Jamon y queso", "ingredientes":[{"nombre": "jamon"}, {"nombre": "queso"}],"precioBase": 1500.0})
db.pizzas.insert({"nombre": "Pepperoni", "ingredientes":[{"nombre": "pepperoni"}, {"nombre": "queso"}],"precioBase": 1500.0})
db.pizzas.insert({"nombre": "Hawaiana", "ingredientes":[{"nombre": "jamon"}, {"nombre": "piña"}, {"nombre": "coco"}],"precioBase": 2000.0})
db.pizzas.insert({"nombre": "Napolitana", "ingredientes":[{"nombre": "tomate en rodajas"}, {"nombre": "oregano"}],"precioBase": 2000.0})


db.createCollection('ingredientes')
db.ingredientes.insert({"nombre": "pepperoni", "precio": 200})
db.ingredientes.insert({"nombre": "carne de res", "precio": 200})
db.ingredientes.insert({"nombre": "carne de cerdo", "precio": 200})
db.ingredientes.insert({"nombre": "hongos", "precio": 200})
db.ingredientes.insert({"nombre": "jamon", "precio": 200})
db.ingredientes.insert({"nombre": "piña", "precio": 200})
db.ingredientes.insert({"nombre": "queso", "precio": 200})
db.ingredientes.insert({"nombre": "coco", "precio": 200})
db.ingredientes.insert({"nombre": "chile dulce", "precio": 200})
db.ingredientes.insert({"nombre": "cebolla", "precio": 200})
db.ingredientes.insert({"nombre": "tomate en rodajas", "precio": 200})
db.ingredientes.insert({"nombre": "pollo", "precio": 200})
db.ingredientes.insert({"nombre": "tocineta", "precio": 200})
db.ingredientes.insert({"nombre": "pesto", "precio": 200})
db.ingredientes.insert({"nombre": "aceitunas", "precio": 200})
db.ingredientes.insert({"nombre": "albahaca", "precio": 200})
db.ingredientes.insert({"nombre": "oregano", "precio": 200})


db.createCollection('bebidas')
db.bebidas.insert({"nombre": "Coca-cola", "precio": 2000})
db.bebidas.insert({"nombre": "Fuze Tea", "precio": 2000})
db.bebidas.insert({"nombre": "Fanta Naranja", "precio": 2000})
db.bebidas.insert({"nombre": "Fanta Kolita", "precio": 2000})

db.createCollection('complementos')
db.complementos.insert({"nombre": "Papas Fritas", "precio": 2000})
db.complementos.insert({"nombre": "Cheese Poppers", "precio": 1600})
db.complementos.insert({"nombre": "Pan de ajo", "precio": 1500})
db.complementos.insert({"nombre": "BreadSticks", "precio": 1530})


//printjson(db.complementos.find().toArray());

db.createCollection('metodosPago')
db.metodosPago.insert({"nombre": "Contado"})
db.metodosPago.insert({"nombre": "Tarjeta"})


db.createCollection('ordenes')
db.ordenes.insert({"ced cliente": "304950273", "nomb cliente" : "Leonardo Baldares Gómez", "num orden" : 1, "fecha" : "Sun Jun 28 01:15:06 CST 2020", "pizzas" : [{ "nombre" : "Suprema", "precio" : 2000.0 }, { "nombre" : "Napolitana", "precio" : 2000.0 }], "extras" : [{ "nombre" : "Coca-cola" }], "estado" : 0, "metodo pago" : "contado", "precio" : 20000.0 })


