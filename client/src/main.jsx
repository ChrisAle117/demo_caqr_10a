import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
<<<<<<< HEAD
import './index.css'
import App from './App.jsx'
=======
import App from './App.jsx'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
>>>>>>> 4e9ad9d ([commit])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
