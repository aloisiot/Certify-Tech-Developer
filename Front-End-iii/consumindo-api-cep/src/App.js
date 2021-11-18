import { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import Swal from 'sweetalert2';
import api from './service/api';
import './App.css';

export default class App extends Component {
  constructor() {
    super();
    this.state = {
      repositorios: {}
    }

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit({ cep }) {
    if (cep) {
      try {
        const response = await api.get(`https://viacep.com.br/ws/${cep}/json/`);
        this.setState({ repositorios: response.data });
        console.log(response.data)
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
      <>
        <main>
          <div className="col-md-4 offset-md-4 col-sm-8 offset-sm-2 my-3 container text-center">
            <h2>Procure um usuário do Github</h2>
            <Formik initialValues={{ cep: '' }} onSubmit={this.handleSubmit}>
              <Form>
                <Field placeholder="Insira o nome do usuário" required type="text" name="cep" id="cep" className="form-control" />
                <button className="btn btn-primary my-4" type="submit">Pesquisar</button>
              </Form>
            </Formik>
            {Object.keys(this.state.repositorios).length > 1 && (
                Object.keys(this.state.repositorios).map(key =>{
                  return (
                    <div>
                        <span>{`${key}: ${this.state.repositorios[key]}`}</span>
                        <br/>
                    </div>
                  );
                })
            )}
          </div>
        </main>
      </>
    );
  }
}