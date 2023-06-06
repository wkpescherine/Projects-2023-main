import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'

import Main from "./main"
import Dashboard from "./dashboard"

function App() {
  return (
    <Router>
      <div className="App">
        <h2>The</h2>
        <h1>NFLysis</h1>
          <Routes>
            <Route exact path="/" element={ <Main />} />
            <Route exact path="/dashboard" element={ <Dashboard />} />
          </Routes>
      </div>
    </Router>
  );
}

export default App;

