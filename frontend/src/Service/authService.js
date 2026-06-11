import api from "../api/axios";

export const login = async (
    email,
    password
) => {

    const response =
        await api.post(
            "/api/auth/login",
            {
                email,
                password
            }
        );

    return response.data;
};

export const getCurrentUser =
    async () => {

        const response =
            await api.get(
                "/api/user/me"
            );

        return response.data;
    };