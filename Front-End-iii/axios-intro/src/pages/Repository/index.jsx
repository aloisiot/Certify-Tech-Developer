import { useEffect, useState } from "react";
import { useParams } from "react-router";
import Swal from "sweetalert2";
import api from '../../service/api'
import { Helmet } from "react-helmet";

export default function Repository() {
    const { repositoryOwner, repositoryName } = useParams();

    const [repo, setRepo] = useState({});


    useEffect(() => {
        async function fetchData() {
            try {
                const response = await api.get(`repos/${repositoryOwner}/${repositoryName}`)
                setRepo(response.data);
            } catch (err) {
                Swal.fire({
                    title: err.response.status,
                    icon: "error",
                    text: err.response.data.message
                })
            }

        }
        fetchData()
    }, [repositoryOwner, repositoryName]);

    return (
        <>
            <Helmet>
                <title> Repositório {repo.name ? "| " + repo.name : ""} </title>
            </Helmet>
            {repo.name && (
                <ul>
                    <li>Nome: {repo.name}</li>
                    <li>Usuario: {repo.owner.login}</li>
                    <li><a href={repo.html_url} target="_blank" rel="noreferrer">Repositório</a></li>
                </ul>
            )}
        </>
    );
}