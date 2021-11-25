import { Field, Form, Formik } from "formik";
import { useEffect, useState } from "react";
import { useParams } from "react-router";
import Swal from "sweetalert2";
import api from "../../service/api";

const OwnerDetails = () => {
    const [owner, setOwner] = useState({});
    const{ userName } = useParams();

    useEffect(() => {
        if(userName){
            getOwnerData({_uName: userName});
            console.log(owner)
        }
    }, [userName])

    const getOwnerData = async ({ _uName }) => {
        const uName = _uName ? _uName : userName;
        try {
            const response = await api.get(`users/${uName}`);
            setOwner(response.data);
        } catch (error) {
            Swal.fire({
                timer: error.response.status,
                icon: "error",
                text: error.response.message
            });
        }
    }
    
    return (
        <>
            <div className="col-md-4 col-sm-6 my-3 container text-center">
                <h1>Procure um usuário do gitHub para ver suas informações</h1>
                <Formik initialValues={{ _uName: "" }} onSubmit={getOwnerData}>
                    <Form>
                        <Field placeholder="Nome do usuário GitHub" require type="text" name="_uName" id="_uName" className="form-control" />
                        <button className="btn btn-primary my-3" type="submit">Enviar</button>
                    </Form>
                </Formik>
                {owner.name  && (
                    <div>
                        <img src={owner.avatar_url} alt="img perfil" />
                        <p>Nome de usuário: {owner.login}</p>

                    </div>
                )}
            </div>
        </>
    );
}

export default OwnerDetails;