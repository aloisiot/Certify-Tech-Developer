import { Component } from "react"
import './style.css'

export default class Cronometro extends Component{

    timer;

    constructor(){
        super()
        this.state = {
            count: 60
        }
    }

    componentDidMount(){
        this.timer = setInterval( _ => this.setState({
            count : this.state.count -1
        }), 1000)
    }

    componentDidUpdate(){
        if(this.state.count <= 0) clearInterval(this.timer);
    }

    render(){
        return(
            <>
                <div id="cron">
                    {this.state.count}
                </div>
            </>
        )
    }
}