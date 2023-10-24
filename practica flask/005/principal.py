from flask import Flask, render_template

app = Flask(__name__)

@app.route('/<nombre>')
def index(nombre):
    datos = {'001': 'Alejandro', '002': 'Juan', '003': 'Pedro'}
    return render_template('index.html', nombre=nombre, usuarios=datos)

if __name__ == '__main__':
    app.run(debug=True, port=8080)