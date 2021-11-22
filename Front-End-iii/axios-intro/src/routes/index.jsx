import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Hello from '../pages/Hello';
import Home from '../pages/Home'

export default function RouteList(){

    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={ <Home/> } />
                <Route path="/hello" element={ <Hello/> } />
            </Routes>
        </BrowserRouter>
    );

}