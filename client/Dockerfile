<<<<<<< HEAD
=======
#Etapa1 : Recursos
>>>>>>> 4e9ad9d ([commit])
FROM node:20 AS build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

<<<<<<< HEAD
RUN npm run build

FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE  80

CMD [ "nginx", "-g", "daemon off;" ]




# Etapa de la imagen
=======
ARG API_HOST
ARG API_PORT
ARG API_BASE

ENV VITE_API_HOST=${API_HOST}
ENV VITE_API_PORT=${API_PORT}
ENV VITE_API_BASE=${API_BASE}

# build the production bundle for nginx
RUN npm run build


#Etapa2 : imagen

FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

>>>>>>> 4e9ad9d ([commit])
