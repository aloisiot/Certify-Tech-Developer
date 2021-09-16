let button = document.querySelector('button')
button.addEventListener('click', function(event) {
    event.preventDefault()

    let usuario = document.getElementById('username').value
    let senha = document.getElementById('password').value

    fetch('https://jsonplaceholder.typicode.com/users', {
            method: 'POST',
            body: JSON.stringify({
                user: usuario,
                password: senha,
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            }
        })
        .then((response) => response.json())
        .then((json) => console.log(json))
})