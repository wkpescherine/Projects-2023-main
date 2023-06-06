import './App.css';

function App() {
  return (
    <div 
      style={{
        margin: "auto",
        width: 800,
        paddingTop: "1rem"
      }}
    >
      <h1 className="title">Pokemon Search</h1>
      <table width="100%">
        <thead>
          <tr>
            <th>NAME</th>
            <th>ELEMENT</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>FirstSection</td>
            <td>SecondSection</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default App;
