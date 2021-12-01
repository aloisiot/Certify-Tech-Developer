import { useState } from 'react';
import { Formik, Form, Field } from 'formik';
import Swal from 'sweetalert2';
import api from '../../service/api';
import Repositorio from './Components/Repositorio';
import { Link } from 'react-router-dom';
import { ListGroup } from 'react-bootstrap';
import { Helmet } from 'react-helmet';

export default function Home() {
  const [repositorios, setRepositorios] = useState([]);

  const handleSubmit = async ({ nomeUsuario }) => {
    if (nomeUsuario) {
      try {
        const response = await api.get(`users/${nomeUsuario}/repos`);
        console.log(response.data)
        setRepositorios(response.data);
      } catch (error) {
        Swal.fire({
          title: error.response.status,
          icon: 'error',
          text: error.response.statusText
        })
      }
    }
  }

  return (
    <main>
      <Helmet>
        <title>
          Home {repositorios.length > 0 ? "| " + repositorios[0].owner.login : ""}
        </title>
      </Helmet>
      <Link to="/hello">Hello</Link>
      <div className="col-md-4 offset-md-4 col-sm-8 offset-sm-2 my-3 container text-center">
        <h2>Procure um usuário do Github</h2>
        <Formik initialValues={{ nomeUsuario: '' }} onSubmit={handleSubmit}>
          <Form>
            <Field placeholder="Insira o nome do usuário" required type="text" name="nomeUsuario" id="nomeUsuario" className="form-control" />
            <button className="btn btn-primary my-4" type="submit">Pesquisar</button>
          </Form>
        </Formik>
        {repositorios.length > 0 && (
          <>
            <ListGroup as="ul">
              {repositorios.map(({ id, name, html_url, full_name }) => {
                return (
                  <Repositorio id={id} name={name} fullName={full_name} />
                );
              })}
            </ListGroup>
          </>
        )}
      </div>
    </main>
  );
}