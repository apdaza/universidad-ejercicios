from flask import Flask, redirect, url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///productos.db'
app.config['SECRET_KEY'] = '5791628bb0b13ce0c676dfde280ba245'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

class producto(db.Model):
    id = db.Column("product_id", db.Integer, primary_key=True)
    producto_nombre = db.Column(db.String(100), nullable=False)
    producto_precio = db.Column(db.Float, nullable=False)
    producto_cantidad = db.Column(db.Integer, nullable=False)

    def __init__(self, datos):
        self.producto_nombre = datos['nombre']
        self.producto_precio = datos['precio']
        self.producto_cantidad = datos['cantidad']

@app.route('/')
def principal():
    data = producto.query.all()
    diccionario_productos = {}
    for d in data:
        diccionario_productos[d.id] = {'nombre': d.producto_nombre, 'precio': d.producto_precio, 'cantidad': d.producto_cantidad}
    return diccionario_productos

@app.route('/agregar/<nombre>/<float:precio>/<int:cantidad>')
def agregar(nombre, precio, cantidad):
    datos = {'nombre': nombre, 'precio': precio, 'cantidad': cantidad}
    p = producto(datos)
    db.session.add(p)
    db.session.commit()
    return redirect(url_for('principal'))

@app.route('/eliminar/<int:id>')
def eliminar(id):
    p = producto.query.get(id)
    db.session.delete(p)
    db.session.commit()
    return redirect(url_for('principal'))

if __name__ == '__main__':
    db.create_all()
    app.run(debug=True, port=8080)