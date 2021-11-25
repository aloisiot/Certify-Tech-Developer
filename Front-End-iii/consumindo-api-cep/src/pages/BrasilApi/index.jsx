import { Formik, Form, Field } from "formik";
import Swal from "sweetalert2";
import api from "../../service/api_brasilapi"
import { Link } from 'react-router-dom';
import { Component } from "react"

export default class ViaCep extends Component {

    constructor() {
        super()
        this.state = {
            repository : {}
        }

        this.handleSubmit = this.handleSubmit.bind(this);

    }

    async handleSubmit({ cep }) {
        if (cep) {
          try {
            const response = await api.get(`https://viacep.com.br/ws/${cep}/json/`);
            this.setState({ repository: response.data });
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
            <div className="col-md-4 offset-md-4 col-sm-8 offset-sm-2 my-3 container text-center">
                <h1>Brasil API</h1>
                <Link to="/"> Via CEP </Link>
                <h2 className="my-5">Procure informaçoes relacionadas a um CEP</h2>
                <Formik initialValues={{ cep: '' }} onSubmit={this.handleSubmit}>
                    <Form>
                        <Field placeholder="Insira o CEP" required type="text" name="cep" id="cep" className="form-control" />
                        <button className="btn btn-primary my-4" type="submit">Pesquisar</button>
                    </Form>
                </Formik>
                
                <ol>
                    {Object.keys(this.state.repository).length > 1 && (
                    <>
                        <div>{
                            this.state.repository &&
                            <Link to={`/${this.state.repository.cep}/${this.state.repository.ddd}`}>DDD</Link>
                        }</div>
                        {Object.keys(this.state.repository).map( (objectKey, i) => {
                            return (
                                <>
                                    <li key={i}> {`${objectKey}: ${this.state.repository[objectKey]}`}</li>
                                    <br />
                                </>
                            );
                        })
                        }
                    </>
                    )}
                    
                </ol>
            </div>
        )
    }
}