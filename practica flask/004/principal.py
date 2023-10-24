from flask import Flask, redirect, url_for

app = Flask(__name__)

@app.route('/admin')
def admin():
    return 'Hola Admin'

@app.route('/user/<name>')
def user(name):
    return 'Hola ' + name + " estas como invitado"

@app.route('/<name>')
def hello(name):
    if name == 'admin':
        return redirect(url_for('admin'))
    else:
        return redirect(url_for('user', name=name))

if __name__ == '__main__':
    app.run(debug=True, port=8080)