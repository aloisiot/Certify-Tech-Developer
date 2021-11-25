import { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import Swal from 'sweetalert2';
import api from '../../service/api_viacep';
import { Link } from 'react-router-dom';

export default class Home extends Component {
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
        const response = await api.get(`https://brasilapi.com.br/api/cep/v1/${cep}`);
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
            <h1> Via CEP </h1>
            <Link to="/brasil_api">Brasil API</Link>
            <h2 className="my-5">Procure informaçoes relacionadas a um CEP</h2>
            <Formik initialValues={{ cep: '' }} onSubmit={this.handleSubmit}>
              <Form>
                <Field placeholder="Insira o CEP" required type="text" name="cep" id="cep" className="form-control" />
                <button className="btn btn-primary my-4" type="submit">Pesquisar</button>
              </Form>
            </Formik>
            <ol>
              {Object.keys(this.state.repositorios).length > 1 && (
                  Object.keys(this.state.repositorios).map((objectKey, i) =>{
                    return (
                      <>
                          <li key={i}> {`${objectKey}: ${this.state.repositorios[objectKey]}`}</li>
                      </>
                    );
                  })
              )}
            </ol>  
          </div>
        </main>
      </>
    );
  }
}