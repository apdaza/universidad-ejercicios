from flask import Flask

app = Flask(__name__)

@app.route('/')
def saludador():
    return 'Hola mundo'

@app.route('/<nombre>')
def saludador_nombre(nombre):
    return 'Hola ' + nombre

@app.route('/<nombre>/<apellido>')
def saludador_nombre_apellido(nombre, apellido):
    return 'Hola ' + nombre + ' ' + apellido

if __name__ == '__main__':
    app.run(debug=True, port=8080)