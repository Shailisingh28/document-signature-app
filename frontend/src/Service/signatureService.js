import api from "../api/axios";

export const createSignature = async (data) => {

    const response = await api.post(
        "/api/signatures",
        data
    );

    return response.data;
};
export const getPendingSignatures =
    async () => {

        const response =
            await api.get(
                "/api/signatures/pending"
            );

        return response.data;
    };
    export const signDocument =
    async (
        signatureId,
        signatureText
    ) => {

        const response =
            await api.post(
                `/api/signatures/${signatureId}/sign`,
                {
                    signatureText
                }
            );

        return response.data;
    };