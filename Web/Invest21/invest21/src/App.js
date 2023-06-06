import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'

import Main from "./views/main"
import Dashboard from "./views/dashboard"
import CreateAccount from "./views/createAccount"

function App() {
  return (
    <Router>
      <div className="App">
        <h1>Invest21</h1>
          <Routes>
            <Route exact path="/" element={ <Main />} />
            <Route exact path="/dashboard" element={ <Dashboard />} />
            <Route exact path="/dashboard/profile" element={ <Dashboard />} />
            <Route exact path="/dashboard/search" element={ <Dashboard />} />
            <Route exact path="/createaccount" element={ <CreateAccount />}/>
          </Routes>
        <h5>version 0.3</h5>
      </div>
    </Router>
  );
}

export default App;
