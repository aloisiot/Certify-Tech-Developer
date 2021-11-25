import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Hello from '../pages/Hello';
import Home from '../pages/Home'
import NotFound from '../pages/NotFound';
import OwnerDetails from '../pages/OwnerDetails';
import Repository from '../pages/Repository';

export default function RouteList(){

    return(
        <BrowserRouter>
            <nav>
                <Link to="/">Home<br/></Link>
                <Link to="/aloisiot/Certify-Tech-Developer">Repositório CTD<br/></Link>
            </nav>
            <Routes>
                <Route path="/" element={ <Home/> } />
                <Route path="/hello" element={ <Hello/> } />
                <Route path="/owner/:userName" element={ <OwnerDetails/> } />
                <Route path="/:repositoryOwner/:repositoryName" element={ <Repository/> } />
                <Route path="*" element={<NotFound/>}/>
            </Routes>
        </BrowserRouter>
    );

}