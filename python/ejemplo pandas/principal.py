from flask import Flask, request, render_template

import pandas as pd
import matplotlib.pyplot as plt
import base64
import io

app = Flask(__name__)

@app.route('/cargador', methods=['POST', 'GET'])
def cargador():
    if request.method == 'GET':
        return render_template('carga.html')
    else:
        archivo = request.files['file']
        archivo.save(archivo.filename)

        df = pd.read_csv(archivo.filename)
        
        df = df.groupby(['ciudades'])['mascotas','hijos','edades','vehiculos'].max().reset_index()

        df.plot(figsize = (10, 10),
                title = "ciudades",
                kind = 'bar',
                x = 'ciudades'
        )

        img = io.BytesIO()

        plt.savefig(img, format='png')

        img.seek(0)

        plot_url = base64.b64encode(img.getvalue()).decode()

        return render_template('resultados.html', imagen = plot_url, tabla = df.to_html(classes='data', header=True, index=False))

if __name__=='__main__':
    app.run()        