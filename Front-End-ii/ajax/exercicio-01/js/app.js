fetch("https://reqres.in/api/users?page=2")
.then(res => {
    res.json()
    .then(e => {
        e.data.forEach(p => {
            document.body.innerHTML += `
            <div>
                <img src="${p.avatar}" ></img>
                <h3> Nome: ${p.first_name} </h3>
                <spam>${p.email}</spam>
            </div>
            `
        });
    })
})