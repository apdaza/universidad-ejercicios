from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        f = request.files['file']
        f.save(f.filename)
        contenido = [x.split(',') for x in open(f.filename).readlines()]
        resultado = []
        for x in contenido:
            resultado.append(x + [sum(map(int, x))])
        return render_template('resultados.html', datos = resultado)
    else:
        return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True, port=8080)