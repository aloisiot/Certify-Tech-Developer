import { BrowserRouter, Routes, Route } from 'react-router-dom';
import BrasilApi from '../pages/BrasilApi';
import Ddd from '../pages/DDD';
import Home from '../pages/Home';


export default function RouteList(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={ <Home/> }/>
                <Route path="/:cep/:ddd" element={ <Ddd/> }/>
                <Route path="/brasil_api" element={ <BrasilApi/> }/>
            </Routes>
        </BrowserRouter>
    );
}