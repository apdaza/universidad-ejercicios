from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        datos = request.form
        return render_template('resultados.html', datos = datos)
    else:
        return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True, port=8080)