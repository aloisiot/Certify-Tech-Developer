import { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import Swal from 'sweetalert2';
import api from '../../service/api';
import Repositorio from './Components/Repositorio';
import { Link } from 'react-router-dom';

export default class Home extends Component {
  constructor() {
    super();
    this.state = {
      repositorios: []
    }

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit({ nomeUsuario }) {
    if (nomeUsuario) {
      try {
        const response = await api.get(`https://api.github.com/users/${nomeUsuario}/repos`);
        this.setState({ repositorios: response.data });
      } catch (error) {
        Swal.fire({
          title: error.response.status,
          icon: 'error',
          text: error.response.statusText
        })
      }
    }
  }

  render() {
    return (
    <main>
        <Link to="/hello">Hello</Link>
        <div className="col-md-4 offset-md-4 col-sm-8 offset-sm-2 my-3 container text-center">
        <h2>Procure um usuário do Github</h2>
        <Formik initialValues={{ nomeUsuario: '' }} onSubmit={this.handleSubmit}>
            <Form>
            <Field placeholder="Insira o nome do usuário" required type="text" name="nomeUsuario" id="nomeUsuario" className="form-control" />
            <button className="btn btn-primary my-4" type="submit">Pesquisar</button>
            </Form>
        </Formik>
        {this.state.repositorios.length > 0 && (
            <>
            <ul>
                {this.state.repositorios.map(({ id, name, html_url }) => {
                return (
                    <Repositorio id={id} name={name} html_url={html_url}/>
                );
                })}
            </ul>
            </>
        )}
        </div>
    </main>
    );
  }
}