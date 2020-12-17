import logo from './logo.svg';
import './App.css';
import React from "react";
import {useState} from "react";
import axios from "axios";

const App = () => {

    const [message, setMessage] = useState("");
    const [changedMessage, setChangedMessage] = useState(false);
    const buttonHandler = () => {
        axios.post("http://localhost:8080/censoring?message="+message, {

        },{
            headers: {
                "Access-Control-Allow-Origin": "*"
            }
        }).then(res => setChangedMessage(res.data))
    }
    return (
        <div className="MainContainer">
            <h1>Censorizer</h1>
            <div className="Content">
                <textarea value={message} onChange={e => setMessage(e.target.value)}/>
                <button onClick={() => buttonHandler()}>Send Message</button>
                <div className="Result">{changedMessage ? changedMessage : null}</div>

            </div>

        </div>
    );
}

export default App;
