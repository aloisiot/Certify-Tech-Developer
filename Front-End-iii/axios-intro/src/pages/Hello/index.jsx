import { Component } from "react";
import { Link } from "react-router-dom";

export default class Hello extends Component{
    render(){
        return(
        <>
            <Link to="/">Home</Link>
            <h1>Hello Router!</h1>
        </>
        );
    }
}