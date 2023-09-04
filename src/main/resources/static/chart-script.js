document.addEventListener('DOMContentLoaded', function() {
    fetch('/grafico-data')  // Cambia la URL según tu controlador de datos
        .then(response => response.json())
        .then(data => {
            const etiquetas = data.etiquetas;
            const montos = data.montos;

            const ctx = document.getElementById('myChart').getContext('2d');
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: etiquetas,
                    datasets: [{
                        label: 'Montos de Venta',
                        data: montos,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    // Opciones de configuración del gráfico
                }
            });
        });
});
