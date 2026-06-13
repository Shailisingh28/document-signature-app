import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import SignaturePlacement
from "./pages/SignaturePlacement";
import Login from "./pages/Login";
import Register from "./pages/Register";

import AdminDashboard from "./pages/AdminDashboard";
import OwnerDashboard from "./pages/OwnerDashboard";
import SignerDashboard from "./pages/SignerDashboard";
import UploadDocument from "./pages/UploadDocument";
import Documents from "./pages/Documents";
import ProtectedRoute from "./Components/ProtectedRoute";

function App() {
    return (
        <BrowserRouter>
            <Routes>

                {/* Default Route */}
                <Route
                    path="/"
                    element={<Navigate to="/login" />}
                />

                {/* Public Routes */}
                <Route
                    path="/login"
                    element={<Login />}
                />

                <Route
                    path="/register"
                    element={<Register />}
                />

                {/* Protected Routes */}
                <Route
                    path="/admin"
                    element={
                        <ProtectedRoute>
                            <AdminDashboard />
                        </ProtectedRoute>
                    }
                />
                <Route
    path="/upload"
    element={
        <ProtectedRoute>
            <UploadDocument />
        </ProtectedRoute>
    }
/>

<Route
    path="/documents"
    element={
        <ProtectedRoute>
            <Documents />
        </ProtectedRoute>
    }
/>
<Route
    path="/signature-placement"
    element={
        <ProtectedRoute>
            <SignaturePlacement />
        </ProtectedRoute>
    }
/>

                <Route
                    path="/owner"
                    element={
                        <ProtectedRoute>
                            <OwnerDashboard />
                        </ProtectedRoute>
                    }
                />

                <Route
                    path="/signer"
                    element={
                        <ProtectedRoute>
                            <SignerDashboard />
                        </ProtectedRoute>
                    }
                />

                {/* 404 Fallback */}
                <Route
                    path="*"
                    element={<h1>404 - Page Not Found</h1>}
                />

            </Routes>
        </BrowserRouter>
    );
}

export default App;