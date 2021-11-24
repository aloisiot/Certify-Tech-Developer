import { Link } from "react-router-dom";

export default function Repositorio ({id, fullName, name}) {
    return <li key={id}> <Link to={fullName}> {name} </Link> </li>;
}