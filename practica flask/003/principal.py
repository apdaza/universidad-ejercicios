from flask import Flask

app = Flask(__name__)

@app.route('/')
def saludador():
    return 'Hola mundo'

@app.route('/<nombre>')
def saludador_nombre(nombre):
    return 'Hola ' + nombre

@app.route('/<int:pos>')
def saludador_pos(pos):
    saludos = ['Hola', 'Buenos días', 'Buenas tardes', 'Buenas noches']
    if pos < len(saludos):
        return saludos[pos]
    return str(pos) + " no existe"

@app.route('/<float:numero>')
def saludador_numero(numero):
    return 'el total es ' + str(numero)


if __name__ == '__main__':
    app.run(debug=True, port=8080)