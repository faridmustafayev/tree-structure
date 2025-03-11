const API_BASE_URL = "https://faridmustafayev.github.io//v1/jurisdictions";

async function addJurisdiction() {
    const name = document.getElementById("jurisdictionName").value;
    const address = document.getElementById("jurisdictionAddress").value;
    const section = document.getElementById("jurisdictionSection").value;
    const type = document.getElementById("jurisdictionType").value;

    if (!name || !address || !section || !type) {
        alert("Bütün sahələri doldurun!");
        return;
    }

    const requestData = {
        name: name,
        address: address,
        sectionWhichItBelongs: section,
        type: type
    };

    try {
        const response = await fetch(API_BASE_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(requestData),
            mode: 'cors' // CORS-u aktiv etmək üçün əlavə edilir
        });

        if (response.status === 201) {
            alert("Jurisdiction uğurla əlavə edildi!");
        } else {
            throw new Error("Jurisdiction əlavə edilə bilmədi");
        }
    } catch (error) {
        alert(`Xəta: ${error.message}`);
    }
}
