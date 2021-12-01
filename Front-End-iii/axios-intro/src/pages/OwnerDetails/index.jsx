import { Field, Form, Formik } from "formik";
import { useCallback, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { Container, Col, Row, ListGroup } from "react-bootstrap";
import Swal from "sweetalert2";
import api from "../../service/api";

const OwnerDetails = () => {
    const [owner, setOwner] = useState({});
    const { userName } = useParams();
    const navigate = useNavigate();

    const getOwnerData = useCallback(async ({ _uName }) => {
        const uName = _uName ? _uName : userName;
        if (uName !== _uName) {
            navigate(`/owner/${_uName}`);
            return;
        }

        try {
            const response = await api.get(`users/${uName}`);
            setOwner(response.data);
            console.log(response)
        } catch (error) {
            Swal.fire({
                timer: error.response.status,
                icon: "error",
                text: error.response.message
            });
        }
    }, [userName, navigate])

    useEffect(() => {
        if (userName) {
            getOwnerData({ _uName: userName });
        }
    }, [userName, getOwnerData])

    return (
        <section>
            <Container>
                <Col md={{ span: 4, offset: 4 }} sm={{ span: 6, offset: 3 }}>
                    <h1>Procure um usuário do gitHub para ver suas informações</h1>
                    <Formik initialValues={{ _uName: "" }} onSubmit={getOwnerData}>
                        <Form>
                            <Field placeholder="Nome do usuário GitHub" require type="text" name="_uName" id="_uName" className="form-control" />
                            <button className="btn btn-primary my-3" type="submit">Enviar</button>
                        </Form>
                    </Formik>
                    {owner && (
                        <div>
                            <img src={owner.avatar_url} alt="img perfil" />
                            <p>Nome de usuário: {owner.login}</p>
                        </div>
                    )}
                </Col>
            </Container>
        </section>
    );
}

export default OwnerDetails;