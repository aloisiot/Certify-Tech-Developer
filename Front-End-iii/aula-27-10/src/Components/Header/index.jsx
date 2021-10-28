import './style.css';
import logo from '../../assets/svg-logo.svg'

const Header = () => {
    return (
        <header>
            <img src={logo} alt="logo" />
        </header>
    );
}

export default Header;