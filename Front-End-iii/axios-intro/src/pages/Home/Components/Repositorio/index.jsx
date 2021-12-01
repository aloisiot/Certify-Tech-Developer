import { Link } from "react-router-dom";
import { ListGroup } from 'react-bootstrap';


export default function Repositorio ({id, fullName, name}) {
    return <ListGroup.Item as="li" key={id}> <Link to={fullName}> {name} </Link> </ListGroup.Item>;
}