import api from "../api/axios";

export const createSignature = async (data) => {

    const response = await api.post(
        "/api/signatures",
        data
    );

    return response.data;
};